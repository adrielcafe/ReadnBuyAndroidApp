package cafe.adriel.vanhackathon.shopify.readnbuy

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.shopify.buy.dataprovider.BuyClient
import com.shopify.buy.dataprovider.BuyClientBuilder
import com.shopify.buy.model.Customer
import com.tsengvn.typekit.Typekit

class App: Application() {

    companion object {
        lateinit var context: Context
            private set
        lateinit var shopify: BuyClient
            private set
        var customer: Customer? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        if(BuildConfig.DEBUG){
            StrictMode.enableDefaults()
        }
        initCustomFonts()
        initShopify()
    }

    private fun initCustomFonts(){
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/Oxygen-Regular.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/Oxygen-Bold.ttf"))
    }

    private fun initShopify(){
        shopify = BuyClientBuilder()
                .shopDomain(Constant.SHOPIFY_DOMAIN)
                .applicationName(Constant.SHOPIFY_APP_NAME)
                .appId(Constant.SHOPIFY_APP_ID)
                .apiKey(Constant.SHOPIFY_API_KEY)
                .build()
    }

}