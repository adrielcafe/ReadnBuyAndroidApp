package cafe.adriel.vanhackathon.shopify.readnbuy.view

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article

interface IMainView {

    fun showArticles(articles: List<Article>)

    fun showArticle(position: Int)

}