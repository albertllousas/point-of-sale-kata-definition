package pos.model

import java.math.BigDecimal

data class Product(
    val productId: String,
    val price: BigDecimal,
    val description: String
)
