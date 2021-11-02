package com.example.loginapp.data.repository

import com.example.loginapp.data.local.entities.UserEntity

class SignInFragmentRepository(private val user: UserEntity) {

    fun getExistingUsers(): List<String> {
        return user.existingUsers
    }

}