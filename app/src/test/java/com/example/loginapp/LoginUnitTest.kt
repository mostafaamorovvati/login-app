package com.example.loginapp

import com.example.loginapp.data.local.entities.UserEntity
import com.example.loginapp.data.repository.LoginFragmentRepository
import com.example.loginapp.ui.login.loginFragment.LoginFragmentViewModel
import com.example.loginapp.utils.Constants
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertFalse
import kotlin.test.assertTrue


@RunWith(JUnit4::class)
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
    fun `empty username returns false`() {
        val result = loginFragmentViewModel.validationInputData(
            null,
            "",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `empty password returns false`() {
        val result = loginFragmentViewModel.validationInputData(
            null,
            "mmm",
            ""
        )
        assertFalse(result)
    }

    @Test
    fun `empty username and password returns false`() {
        val result = loginFragmentViewModel.validationInputData(
            null,
            "",
            ""
        )
        assertFalse(result)
    }

    @Test
    fun `fill username and password returns true`() {
        val result = loginFragmentViewModel.validationInputData(
            null,
            "mmm",
            "123"
        )
        assertTrue(result)
    }


    @Test
    fun `valid username and password`() {
        val result = loginFragmentViewModel.validate("mostafa", "123")
        assertThat(result, `is`(Constants.SUCCESS_MESSAGE))
    }


}