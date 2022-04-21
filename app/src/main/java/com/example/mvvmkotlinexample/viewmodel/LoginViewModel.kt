package com.example.mvvmkotlinexample.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlinexample.model.LoginUser

class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    private var userMutableLiveData: MutableLiveData<LoginUser>? = null
    val user: MutableLiveData<LoginUser>?
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData<LoginUser>()
            }
            return userMutableLiveData
        }

    fun onClick(view: View?) {
        val loginUser = LoginUser(EmailAddress.value!!, Password.value!!)
        userMutableLiveData!!.setValue(loginUser)
    }
}