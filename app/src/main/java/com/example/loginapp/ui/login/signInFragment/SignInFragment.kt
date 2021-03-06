package com.example.loginapp.ui.login.signInFragment

import android.os.Bundle
import android.view.View
import com.example.loginapp.BR
import com.example.loginapp.R
import com.example.loginapp.base.BaseFragment
import com.example.loginapp.databinding.FragmentSignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignInFragment : BaseFragment<FragmentSignInBinding, SignInFragmentViewModel>(),
    SignInFragmentNavigator {

    private lateinit var mBinding: FragmentSignInBinding
    private val mViewModel: SignInFragmentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
    }

    override fun getBindingVariable(): Int {
        return BR.ViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_in
    }

    override fun getViewModel(): SignInFragmentViewModel {
        return mViewModel
    }

    override fun signIn() {
        mBinding.apply {
            mViewModel.validationNewUser(
                requireContext(),
                edtUsername.text.toString().trim(),
                edtEmail.text.toString().trim(),
                edtPassword.text.toString().trim(),
                edtConfirmPassword.text.toString().trim()
            )
        }
    }

}