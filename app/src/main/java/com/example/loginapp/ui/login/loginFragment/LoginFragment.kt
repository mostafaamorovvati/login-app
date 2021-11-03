package com.example.loginapp.ui.login.loginFragment

import android.os.Bundle
import android.view.View
import com.example.loginapp.BR
import com.example.loginapp.R
import com.example.loginapp.base.BaseFragment
import com.example.loginapp.databinding.FragmentLoginBinding
import com.example.loginapp.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>(),
    LoginFragmentNavigator {

    private lateinit var mBinding: FragmentLoginBinding
    private val mViewModel: LoginFragmentViewModel by viewModel()

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
        return R.layout.fragment_login
    }

    override fun getViewModel(): LoginFragmentViewModel {
        return mViewModel
    }

    override fun login() {

        val isValidInput = mViewModel.validationInputData(
            requireContext(),
            mBinding.edtUsername.text.toString().trim(),
            mBinding.edtPassword.text.toString().trim()
        )

        if (isValidInput) {
            val result = mViewModel.validate(
                mBinding.edtUsername.text.toString().trim(),
                mBinding.edtPassword.text.toString().trim()
            )
            activity?.toast(result)
        }

    }


}