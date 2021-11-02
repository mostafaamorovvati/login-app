package com.example.loginapp.ui.login.signInFragment

import com.example.loginapp.base.BaseViewModel

class SignInFragmentViewModel:BaseViewModel<SignInFragmentNavigator>() {


    fun onSignClick(){
        getNavigator()?.signIn()
    }

}