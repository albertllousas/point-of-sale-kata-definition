package pos

import pos.model.DisplayRecord
import pos.model.Product
import java.math.BigDecimal

class PointOfSale {

    fun scan(productId: String) = display(find(productId)!!)

    fun find(productId: String) = products.find { it.productId == productId }

    fun display(product: Product): DisplayRecord =
        DisplayRecord(product.price)

    companion object {
        val products = listOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull")
        )
    }
}
