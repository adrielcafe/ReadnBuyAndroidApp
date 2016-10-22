package cafe.adriel.vanhackathon.shopify.readnbuy

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.tsengvn.typekit.Typekit

class App: Application() {

    companion object {
        lateinit var context: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        if(BuildConfig.DEBUG){
            StrictMode.enableDefaults()
        }
        initCustomFonts()
    }

    private fun initCustomFonts(){
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/Oxygen-Regular.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/Oxygen-Bold.ttf"))
    }

}