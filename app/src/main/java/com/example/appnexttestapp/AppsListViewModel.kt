package com.example.appnexttestapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


enum class State { LOADING, LOADED, ERROR }

class AppsListViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepository = AppsRepository(application)

    // Movies
    private val appsList: MutableLiveData<List<AppModel>> by lazy {
        MutableLiveData<List<AppModel>>().also {
            state.postValue(State.LOADING)
            loadAppsList()
        }
    }

    fun getAppsList(): LiveData<List<AppModel>> = appsList


    // State
    private val state: MutableLiveData<State> by lazy { MutableLiveData<State>() }

    fun getState(): LiveData<State> = state

    // Open details
    private val openDetails: SingleLiveEvent<Int> by lazy { SingleLiveEvent<Int>() }

    fun getOpenDetails(): LiveData<Int> = openDetails


    private fun loadAppsList() {
        moviesRepository.getAppsList().observeForever {
            if (it == null) {
                state.postValue(State.ERROR)
                return@observeForever
            }


            if (it.isNotEmpty()) {
                state.postValue(State.LOADED)
            }
            appsList.postValue(it)
        }
    }



    fun onAppsClicked(adapterPosition: Int) {
        openDetails.postValue(adapterPosition)
    }
}