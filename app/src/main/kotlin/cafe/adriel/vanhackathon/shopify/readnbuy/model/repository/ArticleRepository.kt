package cafe.adriel.vanhackathon.shopify.readnbuy.model.repository

import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import rx.Single
import java.util.*

class ArticleRepository: IArticleRepository {

    override fun getArticles() = Single.defer {
        Single.create<List<Article>> {
            // TODO
            val a1 = Article("Title 1",
                    "<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.</p>" +
                    "<div class='product' data-product-id='6518571909'><img class='product-image' src='https://storage.googleapis.com/madebygoog/v1/phone/phone_hero-module_hero-image_1440_2x.png'><div class='product-price'><sup>$</sup>649</div></div>" +
                    "<p>Sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.</p>",
                    "https://wallpaperscraft.com/image/mountains_sky_bali_sunrise_kintamani_indonesia_95497_602x339.jpg", Calendar.getInstance().time)
            val a2 = Article("Title 2", "Body 2", "http://webneel.com/wallpaper/sites/default/files/images/01-2014/2-flower-wallpaper.preview.jpg", Calendar.getInstance().time)
            val a3 = Article("Title 3", "Body 3", "http://media02.hongkiat.com/ww-flower-wallpapers/dandelion.jpg", Calendar.getInstance().time)
            val a4 = Article("Title 4", "Body 4", "http://interfacelift.com/wallpaper/previews/04077_monuments_672x420.jpg", Calendar.getInstance().time)
            val a5 = Article("Title 5", "Body 5", "http://www.planwallpaper.com/static/images/abstract_wallpaper_xVBXbWX.jpg", Calendar.getInstance().time)
            val articles = listOf(a1, a2, a3, a4, a5)
            it.onSuccess(articles)
        }
    }

}