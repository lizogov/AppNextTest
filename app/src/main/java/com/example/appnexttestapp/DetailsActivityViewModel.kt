package com.example.appnexttestapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val appsRepository = AppsRepository(application)


    private val apps: MutableLiveData<List<AppModel>> by lazy {
        MutableLiveData<List<AppModel>>().also {
            getAppsFromDb()
        }
    }

    fun getApps(): LiveData<List<AppModel>> = apps

    private fun getAppsFromDb() {
        appsRepository.getAppsListFromDb().observeForever {
            it?.let { apps.postValue(it) }
        }
    }

    private val downloadImage: SingleLiveEvent<AppModel> by lazy { SingleLiveEvent<AppModel>() }

    fun getDownloadImage(): LiveData<AppModel> = downloadImage

    fun downloadImageClicked(appModel: AppModel) {
        downloadImage.postValue(appModel)
    }
}