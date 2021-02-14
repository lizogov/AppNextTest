package com.example.appnexttestapp

import android.content.Context
import androidx.lifecycle.MutableLiveData


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppsRepository(private val appContext: Context) {

    private val mutableLiveData = MutableLiveData<List<AppModel>>()

    fun getAppsList(): MutableLiveData<List<AppModel>> {
        getAppsListFromDataBase()
        getAppsListFromServer()
        return mutableLiveData
    }

    fun getAppsListFromDb(): MutableLiveData<List<AppModel>> {
        getAppsListFromDataBase()
        return mutableLiveData
    }

    private fun getAppsListFromDataBase() {
        AppDatabase.getInstance(appContext)?.appDao()?.getAll()?.observeForever {
            it?.let {
                logD("We got ${it.size} apps from DB")
                mutableLiveData.value = it
            }
        }
    }

    private fun getAppsListFromServer() {
        RestClient.APPS_LIST_SERVICE.loadAppList().enqueue(object : Callback<AppsListResult> {
            override fun onFailure(call: Call<AppsListResult>, t: Throwable) {
                logD("On failure: ${t.message}")
                mutableLiveData.value = null
            }

            override fun onResponse(call: Call<AppsListResult>, response: Response<AppsListResult>) {
                logD("On response from server called")
                response.body()?.let {
                    logD("We got fresh ${response.body()!!.most_popular_apps.size} apps")
                    updateDbWithNewApps(AppModelConverter.convertNetworkAppToModel(it))
                }
            }
        })
    }

    private fun updateDbWithNewApps(apps: List<AppModel>) {
        logD("Update DB with fresh apps")
        AppExecutors.diskIO.execute {
            AppDatabase.getInstance(appContext)?.apply {
                appDao()?.deleteAll()
                appDao()?.insertAll(apps)
            }
        }
    }

}