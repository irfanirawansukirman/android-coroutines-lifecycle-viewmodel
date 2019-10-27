package com.irfanirawansukirman.coroutineslifecycleviewmodel

interface MainUseCase {
    fun getMovieList(): List<String>
}

class MainRepository : MainUseCase {
    override fun getMovieList(): List<String> {
        return emptyList()
    }
}