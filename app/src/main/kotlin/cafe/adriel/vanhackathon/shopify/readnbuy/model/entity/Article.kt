package cafe.adriel.vanhackathon.shopify.readnbuy.model.entity

import android.os.Parcel
import android.os.Parcelable

import java.util.*

data class Article(
        val title: String,
        val body: String,
        val imageUrl: String,
        val date: Date) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = Article(source)
            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readSerializable() as Date)

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(body)
        dest?.writeString(imageUrl)
        dest?.writeSerializable(date)
    }

}