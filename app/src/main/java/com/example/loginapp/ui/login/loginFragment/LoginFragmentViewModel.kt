package com.example.loginapp.ui.login.loginFragment

import com.example.loginapp.base.BaseViewModel
import com.example.loginapp.data.repository.LoginFragmentRepository
import com.example.loginapp.utils.Constants

class LoginFragmentViewModel(
    private val repo: LoginFragmentRepository
) : BaseViewModel<LoginFragmentNavigator>() {

    fun validate(userName: String, password: String): String {
        return if (userName == repo.getUserName() && password == repo.getPassword())
            Constants.SUCCESS_MESSAGE else Constants.INVALID_MESSAGE
    }

    fun onLoginClick() {
        getNavigator()?.login()
    }

}