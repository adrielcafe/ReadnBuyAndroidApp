package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.NativeCheckoutEvent
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Product
import cafe.adriel.vanhackathon.shopify.readnbuy.presenter.ArticlePresenter
import cafe.adriel.vanhackathon.shopify.readnbuy.presenter.IArticlePresenter
import cafe.adriel.vanhackathon.shopify.readnbuy.util.prettyDate
import cafe.adriel.vanhackathon.shopify.readnbuy.util.string
import cafe.adriel.vanhackathon.shopify.readnbuy.view.IArticleView
import cafe.adriel.voxrecorder.view.ui.base.BaseFragment
import com.bumptech.glide.Glide
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.pawegio.kandroid.toast
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.dialog_product.view.*
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_article.view.*

class ArticleFragment : BaseFragment(), IArticleView {

    private lateinit var presenter : IArticlePresenter
    private var loadingDialog : SpotsDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ArticlePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_article, container, false)
        view.vBody.let {
            it.settings.defaultFontSize = 20
            it.settings.javaScriptEnabled = true
            it.setWebViewClient(object : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    url?.let {
                        presenter.loadProduct(it)
                    }
                    return true
                }
            })
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Bus.observe<NativeCheckoutEvent>()
                .subscribe { completeCheckout(it.success) }
                .registerInBus(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vBody?.destroy()
    }

    override fun showArticle(article: Article){
        val body = """
            |<!doctype html>
            |<html lang="en">
            |<head>
            |    <meta charset="utf-8">
            |    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
            |    <link type="text/css" rel="stylesheet" href="css/normalize.css">
            |    <link type="text/css" rel="stylesheet" href="css/article.css">
            |</head>
            |<body>
            |   <article>
            |       ${article.body}
            |   </article>
            |
            |   <script type="text/javascript" src="js/zepto.js"></script>
            |   <script type="text/javascript" src="js/article.js"></script>
            |</body>
            |</html>
            """.trimMargin()
        vTitle.text = article.title
        vDate.text = article.date.prettyDate()
        vBody.loadDataWithBaseURL("file:///android_asset/article/", body, "text/html", "utf-8", null)
    }

    override fun showProduct(product: Product){
        val vProduct = LayoutInflater.from(activity).inflate(R.layout.dialog_product, null, false)
        val dialog = AlertDialog.Builder(activity!!)
                .setView(vProduct)
                .create()
        vProduct.run {
            vProductTitle.text = product.title
            vProductPrice.text = "\$${product.price}"
            vProductDescription.text = Html.fromHtml(product.description).toString()
            vProductBack.setOnClickListener {
                dialog.dismiss()
            }
            vProductBuy.setOnClickListener {
                presenter.buyProduct(product)
                dialog.dismiss()
                toggleLoadingDialog(true)
            }
            Glide.with(context)
                .load(product.imageUrl)
                .into(vProductImage)
        }
        dialog.show()
    }

    override fun completeCheckout(success: Boolean) {
        toggleLoadingDialog(false)
        toast(string(if(success) R.string.congrats_for_buy else R.string.unable_buy))
    }

    override fun toggleLoadingDialog(loading: Boolean) {
        if(loading){
            loadingDialog = SpotsDialog(activity, R.style.LoadingDialogStyle)
            loadingDialog?.show()
        } else {
            loadingDialog?.dismiss()
        }
    }

}