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
        find(productId)
            ?.also { shoppingCart.append(it) }
            ?.let { display(it.price) }
            ?: InvalidDisplayRecord()

    private fun find(productId: String) =
        products.find { it.productId == productId }

    private fun display(price: BigDecimal): PriceDisplayRecord =
        PriceDisplayRecord(price)

    fun remove(productId: String): DisplayRecord =
        find(productId)
            ?.also { shoppingCart.remove(it) }
            ?.let { display(it.price.negate()) }
            ?: InvalidDisplayRecord()

    fun cancelSale() = shoppingCart.clear()

    fun checkOut(): DisplayRecord =
        shoppingCart.products.map { it.price }.reduce { a, b -> a.add(b) }.let { display(it) }

    companion object {
        val products = listOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull")
        )
    }
}
