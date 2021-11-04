package com.example.loginapp.utils

import java.util.regex.Pattern

class Constants {

    companion object {
        const val SUCCESS_MESSAGE = "Login was successful"
        const val INVALID_MESSAGE = "Invalid username or password!"

        val VALID_EMAIL_ADDRESS_REGEX: Pattern =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    }
}