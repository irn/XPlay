package xplay.com.xplay

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.Html
import xplay.com.xplay.databinding.ActivityPasswordBinding
import xplay.com.xplay.viewmodel.LoginViewModel

class PasswordActivity : BaseActivity() {

    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding : ActivityPasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_password)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

//        binding.user = viewModel.getUser().value

        binding.textViewForgotPassword.setText(Html.fromHtml(getString(R.string.forgot_password)))
    }
}
