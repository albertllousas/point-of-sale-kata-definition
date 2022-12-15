package pos

class PointOfSale {

    private val productMap = mapOf(ProductId("123456") to Display("1.50"))

    fun scan(productId: ProductId): Display = productMap[productId] ?: Display.invalidProductDisplay

    data class ProductId(val id: String)

    data class Display(val text: String) {
        companion object {
            val invalidProductDisplay: Display = Display("invalid product")
        }
    }
}
