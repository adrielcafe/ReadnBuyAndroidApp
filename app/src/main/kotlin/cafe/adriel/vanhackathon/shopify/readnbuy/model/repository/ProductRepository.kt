package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.App
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
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
                            it.variants[0].price.toFloat())
                }
    }

    override fun buyProduct(id: Long) {
        // TODO
    }

}