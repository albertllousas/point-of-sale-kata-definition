package pos

import pos.Display.*
import java.math.BigDecimal

class PointOfSale(val products: List<Product>) {

    private val currentShoppingCart: MutableList<Product> = mutableListOf()
    fun scan(productId: String): Display =
        products.findById(productId)
            ?.also { currentShoppingCart.add(it) }
            ?.price?.let(::Price) ?: Error("invalid product")

    fun currentShoppingCart(): List<String> = currentShoppingCart.map { it.productId }

    fun remove(productId: String): Display =
        products.findById(productId)
            ?.also { currentShoppingCart.remove(it) }
            ?.price?.negate()?.let(::Price) ?: Error("invalid product")

    data class Product(val productId: String, val price: BigDecimal, val description: String)

    private fun List<Product>.findById(productId: String) = this.find { it.productId == productId }
    fun cancel() = currentShoppingCart.clear()

    fun checkOut(): Price = currentShoppingCart.map { it.price }.sumOf { it }.let(::Price)}

sealed class Display {
    data class Price(val value: BigDecimal) : Display()
    data class Error(val value: String) : Display()
}
