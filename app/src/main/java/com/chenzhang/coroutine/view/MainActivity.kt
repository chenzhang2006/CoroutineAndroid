package com.chenzhang.coroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chenzhang.coroutine.R
import com.chenzhang.coroutine.data.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)

        viewModel.getRooms().observe(this, Observer<List<Room>> { rooms ->
            Log.d(TAG, "View getting new data $rooms")
            main_message.text = rooms.joinToString { it.name }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
