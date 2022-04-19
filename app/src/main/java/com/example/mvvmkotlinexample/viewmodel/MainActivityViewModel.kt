package com.example.mvvmkotlinexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlinexample.model.GetPlansDetails
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.example.mvvmkotlinexample.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ServicesSetterGetter>? = null
    var plansLiveData: MutableLiveData<List<GetPlansDetails>>? = null

    fun getUser() : LiveData<ServicesSetterGetter>? {
        Log.v("DEBUG : ", "mainViewModelCalled inside getUser")

        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }


    fun getPlans() : LiveData<List<GetPlansDetails>>? {
        Log.v("DEBUG : ", "mainViewModelCalled inside getUser")

        plansLiveData = MainActivityRepository.getPlansApiCall()
        return plansLiveData
    }

}