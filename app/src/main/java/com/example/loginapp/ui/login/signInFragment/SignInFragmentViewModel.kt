package com.example.loginapp.ui.login.signInFragment

import com.example.loginapp.base.BaseViewModel
import com.example.loginapp.data.repository.SignInFragmentRepository

class SignInFragmentViewModel(
    private val repo: SignInFragmentRepository
) : BaseViewModel<SignInFragmentNavigator>() {


    fun validationNewUser(
        userName: String, password: String, confirmPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return false
        }
        if (userName in repo.getExistingUsers()) {
            return false
        }
        if (password != confirmPassword) {
            return false
        }
        if (password.length < 3) {
            return false
        }
        return true
    }


    fun onSignClick() {
        getNavigator()?.signIn()
    }

}