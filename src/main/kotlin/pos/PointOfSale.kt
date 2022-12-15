package pos

import pos.model.DisplayRecord
import pos.model.Product
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class PointOfSale {

    fun scan(productId: String): Product? =
        products.find { it.productId == productId }

    fun display(product: Product?): DisplayRecord =
        DisplayRecord(product?.price?.let { priceFormat.format(it) } ?: "invalid product")

    companion object {
        val priceFormat = DecimalFormat("#,###.00", DecimalFormatSymbols(Locale.US))
        val products = listOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull"),
        )
    }
}