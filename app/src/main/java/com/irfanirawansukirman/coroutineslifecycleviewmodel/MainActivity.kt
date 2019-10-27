package com.irfanirawansukirman.coroutineslifecycleviewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // deprecated
        // val viewModel = ViewModelProviders.of(this).get(MainVM::class.java)

        val viewModel = ViewModelProvider(this).get(MainVM::class.java)
        viewModel.apply {
            movieListEvent.observe(this@MainActivity, Observer { data ->
                Log.d("DATA MOVIE 1 SIZE ", data.size.toString())
            })
            movieEvent.observe(this@MainActivity, Observer { data ->
                Log.d("DATA MOVIE 2 SIZE ", data.size.toString())
            })
            getMovies()
        }
    }
}
