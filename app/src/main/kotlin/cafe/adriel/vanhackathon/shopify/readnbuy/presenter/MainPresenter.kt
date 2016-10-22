package cafe.adriel.vanhackathon.shopify.readnbuy.presenter

import cafe.adriel.vanhackathon.shopify.readnbuy.model.repository.ArticleRepository
import cafe.adriel.vanhackathon.shopify.readnbuy.model.repository.IArticleRepository
import cafe.adriel.vanhackathon.shopify.readnbuy.view.IMainView

class MainPresenter(val view: IMainView): IMainPresenter {

    val articleRepo : IArticleRepository = ArticleRepository()

    override fun loadArticles() {
        articleRepo.getArticles()
                .subscribe({
                    view.showArticles(it)
                }, Throwable::printStackTrace)
    }

}