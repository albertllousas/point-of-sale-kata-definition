package pos.model

data class ShoppingCart(
    val products: MutableList<Product> = mutableListOf()
) {

    fun append(product: Product) {
        products.add(product)
    }

    fun remove(product: Product) {
        products.remove(product)
    }

    fun clear() = products.clear()
}
