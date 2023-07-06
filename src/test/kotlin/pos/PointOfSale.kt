package pos

import java.math.BigDecimal

class PointOfSale(val products: List<Product>) {

    private val currentShoppingCart: MutableList<Product> = mutableListOf()
    fun scan(productId: String): String =
        products.find { product -> product.productId == productId }
            ?.also { currentShoppingCart.add(it) }
            ?.price?.toString() ?: "invalid product"

    fun currentShoppingCart(): List<String> = currentShoppingCart.map { it.productId }

    fun remove(productId: String): String = TODO()

    data class Product(
        val productId: String,
        val price: BigDecimal,
        val description: String
    )
}
