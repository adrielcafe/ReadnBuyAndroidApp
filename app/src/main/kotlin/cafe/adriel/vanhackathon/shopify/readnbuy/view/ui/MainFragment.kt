package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cafe.adriel.vanhackathon.shopify.readnbuy.Constant
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.presenter.IMainPresenter
import cafe.adriel.vanhackathon.shopify.readnbuy.presenter.MainPresenter
import cafe.adriel.vanhackathon.shopify.readnbuy.view.IMainView
import cafe.adriel.vanhackathon.shopify.readnbuy.view.adapter.ArticleAdapter
import cafe.adriel.vanhackathon.shopify.readnbuy.view.ui.view.RecyclerItemClickListener
import cafe.adriel.voxrecorder.view.ui.base.BaseFragment
import com.pawegio.kandroid.IntentFor
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : BaseFragment(), IMainView {

    private lateinit var presenter: IMainPresenter
    private lateinit var adapter: ArticleAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = ArticleAdapter()
        view.vRecycler.let {
            it.adapter = adapter
            it.layoutManager = layoutManager
            it.addOnItemTouchListener(RecyclerItemClickListener(activity!!, {
                showArticle(it)
            }))
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.loadArticles()
    }

    override fun showArticles(articles: List<Article>) {
        adapter.load(articles)
    }

    override fun showArticle(position: Int){
        val article = adapter.items[position]
        val intent = IntentFor<ArticleActivity>(activity!!)
        intent.putExtra(Constant.EXTRA_ARTICLE, article)
        startActivity(intent)
    }

}