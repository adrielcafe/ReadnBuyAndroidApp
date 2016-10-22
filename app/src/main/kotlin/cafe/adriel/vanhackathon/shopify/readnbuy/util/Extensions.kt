package cafe.adriel.vanhackathon.shopify.readnbuy.util

import java.text.DateFormat
import java.util.*


fun Date.prettyDate() = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(this)