package com.example.loginapp.ui.login

import com.example.loginapp.base.BaseViewModel
import com.example.loginapp.data.repository.LoginRepository

class LoginViewModel(
    private val repo: LoginRepository
) : BaseViewModel<LoginNavigator>()