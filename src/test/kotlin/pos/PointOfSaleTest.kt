package pos

import java.math.BigDecimal
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    private val pointOfSale = PointOfSale(products = listOf(
        PointOfSale.Product(
            productId = "123456",
            price = BigDecimal("12.50"),
            description = "laptop"
        )
    ))

    @Test
    fun `should display product price when scanned`() {
        val result = pointOfSale.scan("123456")

        assertThat(result).isEqualTo("12.50")
    }

    @Test
    fun `should display invalid product message when scanned product is not found`() {
        val result = pointOfSale.scan("1234")

        assertThat(result).isEqualTo("invalid product")
    }

}
