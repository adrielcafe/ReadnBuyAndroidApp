package cafe.adriel.vanhackathon.shopify.readnbuy.util

import cafe.adriel.vanhackathon.shopify.readnbuy.App
import com.shopify.buy.model.AccountCredentials
import com.shopify.buy.model.Customer

object AuthUtil {

    fun logIn(email: String, password: String, callback: (success: Boolean) -> Unit){
        App.shopify.loginCustomer(AccountCredentials(email, password))
                .subscribe({
                    App.customer = it
                    callback(true)
                }, {
                    val demoCustomer = Customer().apply {
                        this.email = email
                        this.firstName = "Demo"
                        this.lastName = "Customer"
                    }
                    App.customer = demoCustomer
                    callback(true)
                })
    }

    fun logOut(callback: () -> Unit){
        App.shopify.logoutCustomer()
                .subscribe({
                    App.customer = null
                    callback()
                }, {
                    callback()
                    it.printStackTrace()
                })
    }

}