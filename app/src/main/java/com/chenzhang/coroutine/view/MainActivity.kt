package com.chenzhang.coroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chenzhang.coroutine.R
import com.chenzhang.coroutine.data.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var controller: RepoController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://developer.android.com/reference/android/arch/lifecycle/ViewModelProvider
        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)

        controller = RepoController()
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = controller.adapter

        viewModel.getRooms().observe(this, Observer<List<Repo>> { repos ->
            Log.d(TAG, "View getting new data $repos")

            controller.setData(repos)
        })

    }

    companion object {
        const val TAG = "MainActivity"
    }
}

