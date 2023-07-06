package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `should display product price when scanned`() {
        val pointOfSale = PointOfSale()
        val productId = "1234"

        val result = pointOfSale.scan(productId)

        assertThat(result).isEqualTo("12.50")
    }
}
