package com.example.loginapp.ui.login

import android.os.Bundle
import com.example.loginapp.BR
import com.example.loginapp.R
import com.example.loginapp.base.BaseActivity
import com.example.loginapp.databinding.ActivityLoginBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {

    private lateinit var mPagerAdapter: ViewPagerAdapter
    private lateinit var mBinding: ActivityLoginBinding
    private val mViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)

        mPagerAdapter = ViewPagerAdapter(this)
        mBinding.viewPager.adapter = mPagerAdapter
        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.login_txt)
                1 -> tab.text = getString(R.string.sign_in_text)
            }
        }.attach()
        mBinding.viewPager.currentItem = 0

    }

    override fun getBindingVariable(): Int {
        return BR.ViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): LoginViewModel {
        return mViewModel
    }

}