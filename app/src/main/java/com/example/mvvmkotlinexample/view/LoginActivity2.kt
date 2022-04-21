package com.example.mvvmkotlinexample.view

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmkotlinexample.R
import com.example.mvvmkotlinexample.databinding.ActivityLogin2Binding
import com.example.mvvmkotlinexample.viewmodel.LoginViewModel
import java.util.*

class LoginActivity2 : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null

    private var binding: ActivityLogin2Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this@LoginActivity2, R.layout.activity_login2)

        binding!!.setLifecycleOwner(this@LoginActivity2)

        binding!!.setLoginViewModel(loginViewModel)

        loginViewModel!!.user!!.observe(this,
            Observer { loginUser ->
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser)!!.strEmailAddress)) {
                    binding!!.txtEmailAddress.error = "Enter an E-Mail Address"
                    binding!!.txtEmailAddress.requestFocus()
                } else if (!loginUser!!.isEmailValid) {
                    binding!!.txtEmailAddress.error = "Enter a Valid E-mail Address"
                    binding!!.txtEmailAddress.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser)!!.strPassword)) {
                    binding!!.txtPassword.error = "Enter a Password"
                    binding!!.txtPassword.requestFocus()
                } else if (!loginUser!!.isPasswordLengthGreaterThan5) {
                    binding!!.txtPassword.error = "Enter at least 6 Digit password"
                    binding!!.txtPassword.requestFocus()
                } else {
                    binding!!.lblEmailAnswer.text = loginUser!!.strEmailAddress
                    binding!!.lblPasswordAnswer.text = loginUser!!.strPassword
                }
            })


    }
}