package com.example.loginapp.ui.login.loginFragment

import android.content.Context
import com.example.loginapp.base.BaseViewModel
import com.example.loginapp.data.repository.LoginFragmentRepository
import com.example.loginapp.utils.Constants
import com.example.loginapp.utils.toast

class LoginFragmentViewModel(
    private val repo: LoginFragmentRepository
) : BaseViewModel<LoginFragmentNavigator>() {


    fun validationInputData(
        context: Context? = null,
        userName: String,
        password: String
    ): Boolean {

        if (userName.isEmpty() && password.isEmpty()) {
            context?.toast("Please fill fields")
            return false
        }
        if (userName.isEmpty()) {
            context?.toast("Fill username field")
            return false
        }
        if (password.isEmpty()) {
            context?.toast("Fill password field")
            return false
        }
        return true
    }


    fun validate(userName: String, password: String): String {
        return if (userName == repo.getUserName() && password == repo.getPassword())
            Constants.SUCCESS_MESSAGE else Constants.INVALID_MESSAGE
    }


    fun onLoginClick() {
        getNavigator()?.login()
    }

}