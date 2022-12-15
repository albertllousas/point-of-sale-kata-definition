package pos

import pos.model.*
import java.math.BigDecimal

class PointOfSale(
    var shoppingCart: ShoppingCart = ShoppingCart(listOf())
) {

    fun scan(productId: String): DisplayRecord =
        find(productId)?.let { display(it) } ?: InvalidDisplayRecord()

    private fun find(productId: String) =
        products.find { it.productId == productId }

    private fun display(product: Product): PriceDisplayRecord =
        PriceDisplayRecord(product.price)

    companion object {
        val products = listOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull")
        )
    }
}
