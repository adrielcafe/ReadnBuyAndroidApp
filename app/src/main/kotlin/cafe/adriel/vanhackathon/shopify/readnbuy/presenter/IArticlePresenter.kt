package cafe.adriel.vanhackathon.shopify.readnbuy.presenter

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product

interface IArticlePresenter {

    fun loadProduct(productUrl: String)

    fun buyProduct(product: Product)

}