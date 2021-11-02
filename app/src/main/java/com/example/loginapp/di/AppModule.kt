package com.example.loginapp.di

import com.example.loginapp.data.local.entities.UserEntity
import com.example.loginapp.utils.RegistrationUtil
import org.koin.dsl.module

val appModule = module {

    single { UserEntity() }
    single { RegistrationUtil }
}

