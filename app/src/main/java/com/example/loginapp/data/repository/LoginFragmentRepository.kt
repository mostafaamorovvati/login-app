package com.example.loginapp.data.repository

import com.example.loginapp.data.local.entities.UserEntity

class LoginFragmentRepository(private val user: UserEntity) {

    fun getUserName() = user.userName
    fun getPassword() = user.password

}