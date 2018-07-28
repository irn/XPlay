package xplay.com.xplay

import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        textViewSignUp.setText(Html.fromHtml(getString(R.string.sign_up_here)))

    }


}
