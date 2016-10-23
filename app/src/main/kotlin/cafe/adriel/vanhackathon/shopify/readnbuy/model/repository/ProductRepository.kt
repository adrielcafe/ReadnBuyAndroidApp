package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.App
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.NativeCheckoutEvent
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.ProductVariantSerializable
import com.eightbitlab.rxbus.Bus
import com.shopify.buy.model.Cart
import com.shopify.buy.model.Checkout
import com.shopify.buy.model.CreditCard
import rx.Observable

class ProductRepository: IProductRepository {

    override fun getProductById(id: Long) = Observable.defer {
        App.shopify
                .getProduct(id)
                .map {
                    Product(it.productId,
                            it.title,
                            it.bodyHtml,
                            it.firstImageUrl,
                            it.variants[0].price.toFloat(),
                            ProductVariantSerializable(it.variants[0]))
                }
    }

    override fun buyProduct(product: Product) {
        val cart = Cart()
        cart.addVariant(product.variant.variant)

        // TODO mocked credit card for test purposes
        val card = CreditCard()
        card.firstName  = "John"
        card.lastName = "Doe"
        card.month = "1"
        card.year  = "20"
        card.verificationValue = "123"
        card.number = "1"

        var checkout = Checkout(cart)
        checkout.email = App.customer?.email
        checkout.billingAddress = App.customer?.defaultAddress
        checkout.shippingAddress = App.customer?.defaultAddress

        App.shopify.createCheckout(checkout)
                .flatMap {
                    checkout = it
                    App.shopify.getShippingRates(it.token)
                }
                .flatMap {
                    checkout.shippingRate = it[0]
                    App.shopify.updateCheckout(checkout)
                }
                .flatMap {
                    checkout = it
                    App.shopify.storeCreditCard(card, checkout)
                }
                .flatMap {
                    App.shopify.completeCheckout(it, checkout.token)
                }
                .subscribe({
                    Bus.send(NativeCheckoutEvent(true))
                }, {
                    Bus.send(NativeCheckoutEvent(false))
                    it.printStackTrace()
                })
    }

}