package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
import rx.Observable

interface IProductRepository {

    fun getProductById(id: Long): Observable<Product>

    fun buyProduct(id: Long)

}