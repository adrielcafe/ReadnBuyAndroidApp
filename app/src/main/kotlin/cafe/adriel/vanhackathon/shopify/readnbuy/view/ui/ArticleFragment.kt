package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import cafe.adriel.vanhackathon.shopify.readnbuy.Constant
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.util.prettyDate
import cafe.adriel.voxrecorder.view.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_article.view.*

class ArticleFragment : BaseFragment() {

    companion object {

        fun newInstance(article: Article) : ArticleFragment {
            val args = Bundle()
            args.putParcelable(Constant.EXTRA_ARTICLE, article)

            val fragment = ArticleFragment()
            fragment.arguments = args
            return fragment
        }

    }

    lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = arguments.getParcelable(Constant.EXTRA_ARTICLE)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_article, container, false)
        view.vBody.let {
            it.settings.defaultFontSize = 18
            it.setWebViewClient(object : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    url?.let {
                        showProduct(it)
                    }
                    return true
                }
            })
        }
        loadArticle(view)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vBody?.destroy()
    }

    private fun loadArticle(view: View){
        val body = """
            |<!doctype html>
            |<html lang="en">
            |<head>
            |    <meta charset="utf-8">
            |    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
            |    <link rel="stylesheet" type="text/css" href="normalize.css">
            |    <link rel="stylesheet" type="text/css" href="article.css">
            |</head>
            |<body>
            |   <article>
            |       ${article.body}
            |   <article>
            |</body>
            |</html>
            """.trimMargin()
        view.vTitle.text = article.title
        view.vDate.text = article.date.prettyDate()
        view.vBody.loadDataWithBaseURL("file:///android_asset/article/", body, "text/html", "utf-8", null)
    }

    private fun showProduct(url: String){

    }

}