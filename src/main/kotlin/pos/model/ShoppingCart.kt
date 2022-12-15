package pos.model

data class ShoppingCart(
    val products: MutableList<Product> = mutableListOf()
) {

    fun append(product: Product): Unit {
        products.add(product)
    }

    fun remove(product: Product) {
        products.remove(product)
    }
}
