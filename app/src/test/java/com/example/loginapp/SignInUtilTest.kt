package com.example.loginapp

import com.example.loginapp.data.local.entities.UserEntity
import com.example.loginapp.data.repository.SignInFragmentRepository
import com.example.loginapp.ui.login.signInFragment.SignInFragmentViewModel
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
class SignInUtilTest : KoinTest {

    private val signInFragmentViewModel: SignInFragmentViewModel by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            module {
                single { UserEntity() }
                single { SignInFragmentRepository(get()) }
                single { SignInFragmentViewModel(get()) }
            })
    }


    @Test
    fun `empty username returns false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "",
            "123",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `empty password returns false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "mmm",
            "",
            ""
        )
        assertFalse(result)
    }

    @Test
    fun `empty confirm password returns false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "mmm",
            "123",
            ""
        )
        assertFalse(result)
    }


    @Test
    fun `fill username and password and confirm password returns true`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "mmm",
            "123",
            "123"
        )
        assertTrue(result)
    }


    @Test
    fun `username and correctly repeated password returns true`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "mmm",
            "123",
            "123"
        )
        assertTrue(result)
    }

    @Test
    fun `username already exists returns false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "mostafa",
            "123",
            "123"
        )
        assertFalse(result)
    }


    @Test
    fun `incorrect confirm password returns false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "reza",
            "123",
            "1234"
        )
        assertFalse(result)
    }

    @Test
    fun `less than three digit password return false`() {
        val result = signInFragmentViewModel.validationNewUser(
            null,
            "reza",
            "12",
            "12"
        )
        assertFalse(result)
    }

}