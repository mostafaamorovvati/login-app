package com.example.loginapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.loginapp.ui.login.loginFragment.LoginFragment
import com.example.loginapp.ui.login.signInFragment.SignInFragment

const val LOGIN_FRAGMENT = 0
const val SIGN_IN_FRAGMENT = 1

class ViewPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            LOGIN_FRAGMENT -> LoginFragment()
            SIGN_IN_FRAGMENT -> SignInFragment()
            else -> LoginFragment()
        }
    }
}