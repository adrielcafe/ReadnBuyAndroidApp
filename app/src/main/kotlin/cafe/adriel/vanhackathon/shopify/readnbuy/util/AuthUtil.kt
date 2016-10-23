package cafe.adriel.vanhackathon.shopify.readnbuy.util

import cafe.adriel.vanhackathon.shopify.readnbuy.App
import com.shopify.buy.model.AccountCredentials

object AuthUtil {

    fun logIn(email: String, password: String, callback: (success: Boolean) -> Unit){
        App.shopify.loginCustomer(AccountCredentials(email, password))
                .subscribe({
                    callback(true)
                }, {
                    callback(false)
                })
    }

    fun logOut(callback: () -> Unit){
        App.shopify.logoutCustomer()
                .subscribe({
                    callback()
                }, {
                    callback()
                    it.printStackTrace()
                })
    }

}