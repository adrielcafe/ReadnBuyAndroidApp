package cafe.adriel.vanhackathon.shopify.readnbuy.view

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product

interface IArticleView {

    fun showArticle(article: Article)

    fun showProduct(product: Product)

    fun completeCheckout(success: Boolean)

    fun toggleLoadingDialog(loading: Boolean)

}