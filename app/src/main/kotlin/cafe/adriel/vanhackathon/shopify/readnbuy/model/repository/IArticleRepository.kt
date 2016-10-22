package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import rx.Single

interface IArticleRepository {

    fun getArticles() : Single<List<Article>>

}