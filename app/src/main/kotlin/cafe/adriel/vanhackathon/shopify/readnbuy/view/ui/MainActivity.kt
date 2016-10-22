package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.voxrecorder.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(vToolbar)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false)
        }
    }

}