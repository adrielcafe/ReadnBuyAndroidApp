package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.content.Intent
import android.os.Bundle
import cafe.adriel.vanhackathon.shopify.readnbuy.Constant
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.util.AuthUtil
import cafe.adriel.vanhackathon.shopify.readnbuy.util.string
import cafe.adriel.vanhackathon.shopify.readnbuy.view.ILogInView
import cafe.adriel.voxrecorder.view.ui.base.BaseActivity
import com.pawegio.kandroid.IntentFor
import com.pawegio.kandroid.toast
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : BaseActivity(), ILogInView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        vEmail.setText(Constant.TEST_EMAIL)
        vPassword.setText(Constant.TEST_PASSWORD)
        vLogIn.setOnClickListener {
            logIn()
        }
        vRegister.setOnClickListener {
            register()
        }
        vRecoverPassword.setOnClickListener {
            recoverPassword()
        }
    }

    override fun logIn(){
        val email = vEmail.text.toString()
        val password = vPassword.text.toString()
        AuthUtil.logIn(email, password, { success ->
            if(success){
                startActivity(IntentFor<MainActivity>(this))
                finish()
            } else {
                toast(string(R.string.unable_log_in))
            }
        })
    }

    override fun register(){
        val intent = Intent(Intent.ACTION_VIEW, Constant.SHOPIFY_REGISTER_URL)
        startActivity(intent)
    }

    override fun recoverPassword(){
        val intent = Intent(Intent.ACTION_VIEW, Constant.SHOPIFY_RECOVER_PASSWORD_URL)
        startActivity(intent)
    }

}