package com.irfanirawansukirman.coroutineslifecycleviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainVM : ViewModel() {

    val movieListEvent = MutableLiveData<List<String>>()

    // style livedata version 2.2.0-alpha01
    val movieEvent = liveData(Dispatchers.IO) {
        val movie = mutableListOf<String>().apply {
            add("")
            add("")
            add("")
            add("")
            add("")
        }
        emit(movie)
    }

    // style livedata version < 2.2.0-alpha01
    fun getMovies() {
        viewModelScope.launch {
            var movieList = emptyList<String>()
            withContext(Dispatchers.IO) {
                val data = mutableListOf<String>().apply {
                    add("")
                    add("")
                    add("")
                    add("")
                    add("")
                }
                movieList = data
            }
            movieListEvent.value = movieList
        }
    }
}