package pos

class PointOfSale {

    private val productMap = mapOf(ProductId(123456) to Display("1.50"))

    fun scan(productId: ProductId): Display? = productMap[productId]

    data class ProductId(val id: Number)

    data class Display(val price: String)
}
