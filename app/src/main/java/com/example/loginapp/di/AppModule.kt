package com.example.loginapp.di

import com.example.loginapp.data.local.entities.UserEntity
import org.koin.dsl.module

val appModule = module {
    single { UserEntity() }
}

