package com.example.mvvmkotlinexample.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlinexample.Adapter.GetPlansAdapter
import com.example.mvvmkotlinexample.R
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.example.mvvmkotlinexample.repository.MainActivityRepository
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import com.example.mvvmkotlinexample.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        Log.d("DEBUG : ", "mainActivity")

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {

            wp7progressBar.showProgressBar()

            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

                wp7progressBar.hideProgressBar()

                val msg = serviceSetterGetter.message

                lblResponse.text = msg

            })

            mainActivityViewModel.getPlans()!!.observe(this, Observer { serviceSetterGetter ->

                wp7progressBar.hideProgressBar()

                val msg = serviceSetterGetter

                lblResponse.text = msg[1].planName



                // getting the recyclerview by its id
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

                // this creates a vertical layout Manager
                recyclerview.layoutManager = LinearLayoutManager(this)


                // This will pass the ArrayList to our Adapter
                val adapter = GetPlansAdapter(msg)

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter
                wp7progressBar.hideProgressBar()


            })

        }

    }
}
