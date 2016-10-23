package cafe.adriel.vanhackathon.shopify.readnbuy.util

import android.content.Intent
import android.graphics.Color
import android.support.annotation.StringRes
import android.view.MenuItem
import cafe.adriel.vanhackathon.shopify.readnbuy.App
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon
import java.text.DateFormat
import java.util.*

fun string(@StringRes resId: Int, vararg args: String = emptyArray()) = App.context.getString(resId, *args)

fun Date.prettyDate() = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(this)

fun MenuItem.setFontIcon(icon: IIcon) {
    setIcon(IconicsDrawable(App.context)
            .icon(icon)
            .color(Color.WHITE)
            .sizeDp(24))
}

fun Intent.isCheckoutFinished(): Boolean {
    if(this.dataString != null){
        return this.dataString.let {
            it.startsWith("http://readnbuy.com") && it.contains("checkout") && it.contains("token")
        }
    } else {
        return false
    }
}