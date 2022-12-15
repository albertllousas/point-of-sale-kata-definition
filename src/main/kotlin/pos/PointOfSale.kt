package pos

class PointOfSale {

    fun scan(productId: ProductId): Display {
        return fetchPrice(productId.id)
    }

    private fun fetchPrice(productId: Number): Display {
        return Display("1.50")
    }

    data class ProductId(val id: Number)

    data class Display(val price: String)

}