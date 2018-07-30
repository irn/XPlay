package xplay.com.xplay

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.databinding.ObservableField
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_login.*
import xplay.com.xplay.databinding.ActivityLoginBinding
import xplay.com.xplay.model.User
import xplay.com.xplay.viewmodel.LoginViewModel

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        viewModel = ViewModelProviders.of(this, modelFactory).get(LoginViewModel::class.java)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setLifecycleOwner(this)

        binding.textViewContinue.setOnClickListener {
//            viewModel.getUser().login = binding.fieldLogin.text.toString()
            intent = Intent(it.context, PasswordActivity::class.java)
            startActivity(intent)
        }

        textViewSignUp.setText(Html.fromHtml(getString(R.string.sign_up_here)))

    }


}
