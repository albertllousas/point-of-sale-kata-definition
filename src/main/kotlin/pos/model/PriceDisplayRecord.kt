package pos.model

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

data class PriceDisplayRecord(
    val price: BigDecimal
) : DisplayRecord {
    override fun display() = price.let { priceFormat.format(it) }

    companion object {
        val priceFormat = DecimalFormat("#,###.00", DecimalFormatSymbols(Locale.US))
    }
}

class InvalidDisplayRecord() : DisplayRecord {
    override fun display(): String =
        "invalid product"

}

interface DisplayRecord {
    fun display(): String
}
