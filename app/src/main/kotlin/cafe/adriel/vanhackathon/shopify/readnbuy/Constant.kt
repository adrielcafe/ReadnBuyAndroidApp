package cafe.adriel.vanhackathon.shopify.readnbuy

import android.net.Uri

object Constant {

    val SHOPIFY_DOMAIN = "promotedcontentshop.myshopify.com"
    val SHOPIFY_APP_NAME = BuildConfig.APPLICATION_ID
    val SHOPIFY_APP_ID = "8"
    val SHOPIFY_API_KEY = "a8574d99635e142c71b2b8aa1afc5be4"
    val SHOPIFY_REGISTER_URL = Uri.parse("http://$SHOPIFY_DOMAIN/account/register")
    val SHOPIFY_RECOVER_PASSWORD_URL = Uri.parse("http://$SHOPIFY_DOMAIN/account/login")

    val TEST_EMAIL = "demo@demo.com"
    val TEST_PASSWORD = "123456"

    val EXTRA_ARTICLE = "article"

}