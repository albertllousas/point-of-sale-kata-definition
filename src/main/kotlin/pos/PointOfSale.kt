package pos

class PointOfSale {

    fun scan(productId: String): String =
        products.getOrDefault(productId, "invalid product")

    companion object {
        val products = mapOf(
                "901234" to "1.50"
        )
    }
}