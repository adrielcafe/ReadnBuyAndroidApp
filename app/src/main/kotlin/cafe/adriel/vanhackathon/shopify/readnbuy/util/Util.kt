package cafe.adriel.vanhackathon.shopify.readnbuy.util

object Util {

    fun getProductId(url: String) = url.substringAfterLast("/").toLong()

}