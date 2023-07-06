package pos

import java.math.BigDecimal

class PointOfSale(val products: List<Product>) {
    fun scan(productId: String): String =
        products.find { product -> product.productId == productId } ?.price?.toString() ?: "invalid product"

    fun currentShoppingCart(): List<String> = TODO()

    data class Product(
        val productId: String,
        val price: BigDecimal,
        val description: String
    )
}
