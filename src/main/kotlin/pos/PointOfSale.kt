package pos

class PointOfSale {

    private val productMap = mapOf(ProductId("123456") to Display("1.50"),
                                    ProductId("654321") to Display("2") )

    private val shoppingBag = arrayListOf<ProductId>()

    fun scan(productId: ProductId): Display {
       return productMap[productId]?.let {
           shoppingBag.add(productId)
           it
       } ?: Display.invalidProductDisplay
    }

    fun listProducts(): ArrayList<ProductId> = shoppingBag

    data class ProductId(val id: String)

    data class Display(val text: String) {
        companion object {
            val invalidProductDisplay: Display = Display("invalid product")
        }
    }
}
