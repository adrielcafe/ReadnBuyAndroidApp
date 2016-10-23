package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.util.AuthUtil
import cafe.adriel.vanhackathon.shopify.readnbuy.util.setFontIcon
import cafe.adriel.vanhackathon.shopify.readnbuy.util.string
import cafe.adriel.voxrecorder.view.ui.base.BaseActivity
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.pawegio.kandroid.IntentFor
import com.pawegio.kandroid.runDelayed
import com.pawegio.kandroid.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var backPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(vToolbar)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onBackPressed() {
        if (backPressed) {
            super.onBackPressed()
        } else {
            backPressed = true
            toast(string(R.string.press_back_again))
            runDelayed(3000, { backPressed = false })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        menu.run {
            findItem(R.id.log_out)?.setFontIcon(GoogleMaterial.Icon.gmd_exit_to_app)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.log_out -> {
                logOut()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logOut(){
        AuthUtil.logOut {
            startActivity(IntentFor<LogInActivity>(this))
            finish()
        }
    }

}