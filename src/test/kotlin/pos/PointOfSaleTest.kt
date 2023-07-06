package pos

import java.math.BigDecimal
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `should display product price when scanned`() {
        val pointOfSale = PointOfSale(products = listOf(
            PointOfSale.Product(
                productId = "123456",
                price = BigDecimal("12.50"),
                description = "laptop"
            )
        ))

        val result = pointOfSale.scan("123456")

        assertThat(result).isEqualTo("12.50")
    }
}
