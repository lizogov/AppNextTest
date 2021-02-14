package com.example.appnexttestapp

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateWorker(ctx: Context, params:WorkerParameters): CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
         try {
            logD("getAppsList called")
            var output: AppsListResult? = null
            RestClient.APPS_LIST_SERVICE.loadAppList().enqueue(object : Callback<AppsListResult> {
                override fun onFailure(call: Call<AppsListResult>, t: Throwable) {
                    logD("worker e")
//                    output.value = null
                }

                override fun onResponse(call: Call<AppsListResult>, response: Response<AppsListResult>) {
                    logD("On response from server called")
                    response.body()?.let {
                        logD("worker d")
                        val res = AppModelConverter.convertNetworkAppToModel(it)
                        AppExecutors.diskIO.execute {
                            AppDatabase.getInstance(applicationContext )?.apply {
                                appDao()?.deleteAll()
                                appDao()?.insertAll(res)
                            }
                        }
                    }
                }
            })
             Result.success()
        }catch (e:Exception){
            Result.failure()
        }

    }


}