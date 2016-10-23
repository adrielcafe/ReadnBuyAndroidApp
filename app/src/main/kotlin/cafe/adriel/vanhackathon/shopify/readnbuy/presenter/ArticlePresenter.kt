package cafe.adriel.vanhackathon.shopify.readnbuy.presenter

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
import cafe.adriel.vanhackathon.shopify.readnbuy.model.repository.IProductRepository
import cafe.adriel.vanhackathon.shopify.readnbuy.model.repository.ProductRepository
import cafe.adriel.vanhackathon.shopify.readnbuy.util.Util
import cafe.adriel.vanhackathon.shopify.readnbuy.view.IArticleView

class ArticlePresenter(val view: IArticleView): IArticlePresenter {

    val productRepo : IProductRepository = ProductRepository()

    override fun loadProduct(productUrl: String) {
        try {
            val productId = Util.getProductId(productUrl)
            productRepo.getProductById(productId)
                    .subscribe({
                        view.showProduct(it)
                    }, Throwable::printStackTrace)
        } catch (e: Exception){ }
    }

    override fun buyProduct(product: Product) {
        productRepo.buyProduct(product)
    }

}