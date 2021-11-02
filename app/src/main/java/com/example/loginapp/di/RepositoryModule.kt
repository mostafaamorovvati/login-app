package com.example.loginapp.di

import com.example.loginapp.data.repository.LoginFragmentRepository
import com.example.loginapp.data.repository.LoginRepository
import com.example.loginapp.data.repository.SignInFragmentRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { LoginRepository() }
    single { LoginFragmentRepository(get()) }
    single { SignInFragmentRepository(get()) }
}