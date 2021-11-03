package com.example.loginapp

import com.example.loginapp.data.local.entities.UserEntity
import com.example.loginapp.data.repository.LoginFragmentRepository
import com.example.loginapp.ui.login.loginFragment.LoginFragmentViewModel
import com.example.loginapp.utils.Constants
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class LoginUnitTest : KoinTest {

    private val loginFragmentViewModel: LoginFragmentViewModel by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            module {
                single { UserEntity() }
                single { LoginFragmentRepository(get()) }
                single { LoginFragmentViewModel(get()) }
            })
    }


    @Test
    fun `validate test`() {
        val result = loginFragmentViewModel.validate("mostafa", "123")
        assertThat(result, `is`(Constants.SUCCESS_MESSAGE))
    }


}