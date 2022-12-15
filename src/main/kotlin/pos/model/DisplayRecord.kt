package pos.model

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

data class DisplayRecord(
    val price: BigDecimal
) {
    fun display() = price.let { priceFormat.format(it) }

    companion object {
        val priceFormat = DecimalFormat("#,###.00", DecimalFormatSymbols(Locale.US))
    }
}
