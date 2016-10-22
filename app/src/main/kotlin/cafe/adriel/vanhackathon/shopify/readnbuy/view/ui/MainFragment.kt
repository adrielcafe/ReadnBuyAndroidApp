package cafe.adriel.vanhackathon.shopify.readnbuy.view.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cafe.adriel.vanhackathon.shopify.readnbuy.Constant
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.view.adapter.ArticleAdapter
import cafe.adriel.vanhackathon.shopify.readnbuy.view.ui.view.RecyclerItemClickListener
import cafe.adriel.voxrecorder.view.ui.base.BaseFragment
import com.pawegio.kandroid.IntentFor
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.*

class MainFragment : BaseFragment() {

    private lateinit var adapter: ArticleAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = ArticleAdapter()
        view.vRecycler.let {
            it.adapter = adapter
            it.layoutManager = layoutManager
            it.addOnItemTouchListener(RecyclerItemClickListener(activity, {
                showArticle(it)
            }))
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO
        val a1 = Article("Title 1", "Body 1", "https://wallpaperscraft.com/image/mountains_sky_bali_sunrise_kintamani_indonesia_95497_602x339.jpg", Calendar.getInstance().time)
        val a2 = Article("Title 2", "Body 2", "http://webneel.com/wallpaper/sites/default/files/images/01-2014/2-flower-wallpaper.preview.jpg", Calendar.getInstance().time)
        val a3 = Article("Title 3", "Body 3", "http://media02.hongkiat.com/ww-flower-wallpapers/dandelion.jpg", Calendar.getInstance().time)
        val a4 = Article("Title 4", "Body 4", "http://interfacelift.com/wallpaper/previews/04077_monuments_672x420.jpg", Calendar.getInstance().time)
        val a5 = Article("Title 5", "Body 5", "http://www.planwallpaper.com/static/images/abstract_wallpaper_xVBXbWX.jpg", Calendar.getInstance().time)
        val articles = listOf(a1, a2, a3, a4, a5)
        adapter.load(articles)
    }

    private fun showArticle(position: Int){
        val article = adapter.items[position]
        val intent = IntentFor<ArticleActivity>(activity)
        intent.putExtra(Constant.EXTRA_ARTICLE, article)
        startActivity(intent)
    }

}