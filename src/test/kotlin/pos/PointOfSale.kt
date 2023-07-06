package pos

import java.math.BigDecimal

class PointOfSale(val products: List<Product>) {

    private val currentShoppingCart: MutableList<Product> = mutableListOf()
    fun scan(productId: String): String =
        products.findById(productId)
            ?.also { currentShoppingCart.add(it) }
            ?.price?.toString() ?: "invalid product"

    fun currentShoppingCart(): List<String> = currentShoppingCart.map { it.productId }

    fun remove(productId: String): String =
          products.findById(productId)
                ?.also { currentShoppingCart.remove(it) }
                ?.price?.negate()?.toString() ?: "invalid product"

    data class Product(val productId: String, val price: BigDecimal, val description: String)
    private fun List<Product>.findById(productId: String) = this.find { it.productId == productId }
}
