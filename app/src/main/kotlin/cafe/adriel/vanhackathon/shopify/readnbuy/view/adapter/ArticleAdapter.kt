package cafe.adriel.vanhackathon.shopify.readnbuy.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cafe.adriel.vanhackathon.shopify.readnbuy.R
import cafe.adriel.vanhackathon.shopify.readnbuy.model.entity.Article
import cafe.adriel.vanhackathon.shopify.readnbuy.util.prettyDate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_article.view.*
import java.util.*

class ArticleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = LinkedList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).bind(items[position])
    }

    override fun getItemCount() = items.size

    fun load(articles: List<Article>){
        if(articles.isNotEmpty()){
            items.run {
                clear()
                addAll(articles)
                notifyDataSetChanged()
            }
        }
    }

    inner class ArticleViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: Article) {
            view.run {
                tag = this
                vTitle.text = item.title
                vDate.text = item.date.prettyDate()
                Glide.with(context)
                    .load(item.imageUrl)
                    .into(vImage)
            }
        }

    }

}