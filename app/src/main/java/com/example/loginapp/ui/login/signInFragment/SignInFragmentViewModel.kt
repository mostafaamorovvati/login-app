package com.example.loginapp.ui.login.signInFragment

import android.content.Context
import com.example.loginapp.base.BaseViewModel
import com.example.loginapp.data.repository.SignInFragmentRepository
import com.example.loginapp.utils.toast

class SignInFragmentViewModel(
    private val repo: SignInFragmentRepository
) : BaseViewModel<SignInFragmentNavigator>() {

    fun validationNewUser(
        context: Context? = null,
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        if (userName.isEmpty() && password.isEmpty() && confirmPassword.isEmpty()) {
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

        if (confirmPassword.isEmpty()) {
            context?.toast("Please confirm password")
            return false
        }

        if (userName in repo.getExistingUsers()) {
            context?.toast("This username already exists")
            return false
        }

        if (password != confirmPassword) {
            context?.toast("Password mismatch")
            return false
        }

        if (password.length < 3) {
            context?.toast("Entered password is short")
            return false
        }

        context?.toast("Registration completed successfully")
        return true
    }


    fun onSignClick() {
        getNavigator()?.signIn()
    }

}