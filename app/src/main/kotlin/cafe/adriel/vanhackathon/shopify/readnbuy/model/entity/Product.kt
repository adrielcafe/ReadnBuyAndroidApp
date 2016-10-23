package cafe.adriel.vanhackathon.shopify.readnbuy.model.entity

import android.os.Parcel
import android.os.Parcelable

data class Product(
        val id: Long,
        val title: String,
        val description: String,
        val imageUrl: String,
        val price: Float,
        val variant: ProductVariantSerializable) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Product> = object : Parcelable.Creator<Product> {
            override fun createFromParcel(source: Parcel): Product = Product(source)
            override fun newArray(size: Int): Array<Product?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readLong(), source.readString(), source.readString(), source.readString(), source.readFloat(), source.readSerializable() as ProductVariantSerializable)

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeLong(id)
        dest?.writeString(title)
        dest?.writeString(description)
        dest?.writeString(imageUrl)
        dest?.writeFloat(price)
        dest?.writeSerializable(variant)
    }

}