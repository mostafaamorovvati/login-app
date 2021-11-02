package com.example.loginapp.di

import com.example.loginapp.ui.login.LoginViewModel
import com.example.loginapp.ui.login.loginFragment.LoginFragmentViewModel
import com.example.loginapp.ui.login.signInFragment.SignInFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        LoginFragmentViewModel(get())
    }

    viewModel {
        SignInFragmentViewModel()
    }

}