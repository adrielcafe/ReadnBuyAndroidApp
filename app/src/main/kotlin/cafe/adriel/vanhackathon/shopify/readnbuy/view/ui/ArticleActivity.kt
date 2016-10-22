package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.voxrecorder.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class ArticleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(vToolbar)
        supportActionBar?.run {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

}
