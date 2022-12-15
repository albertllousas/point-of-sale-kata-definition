package pos

import pos.model.DisplayRecord
import pos.model.InvalidDisplayRecord
import pos.model.PriceDisplayRecord
import pos.model.Product
import pos.model.ShoppingCart
import java.math.BigDecimal

class PointOfSale(
    val shoppingCart: ShoppingCart = ShoppingCart()
) {

    fun scan(productId: String): DisplayRecord =
        find(productId)?.also {
            shoppingCart.append(it)
        }?.let {
            display(it)
        } ?: InvalidDisplayRecord()

    private fun find(productId: String) =
        products.find { it.productId == productId }

    private fun display(product: Product): PriceDisplayRecord =
        PriceDisplayRecord(product.price)

    fun remove(productId: String): DisplayRecord = TODO()

    companion object {
        val products = listOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull")
        )
    }
}
