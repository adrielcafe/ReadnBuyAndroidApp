package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.App
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.ProductVariantSerializable
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.WebCheckoutEvent
import cafe.adriel.vanhackathon.shopify.readnbuy.util.string
import com.eightbitlab.rxbus.Bus
import com.shopify.buy.model.Cart
import com.shopify.buy.model.Checkout
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
        val checkout = Checkout(cart)
        checkout.setWebReturnToUrl("http://readnbuy.com")
        checkout.setWebReturnToLabel(string(R.string.return_app))
        App.shopify.createCheckout(checkout)
                .subscribe({
                    Bus.send(WebCheckoutEvent(it.webUrl))
                }, Throwable::printStackTrace)
    }

}