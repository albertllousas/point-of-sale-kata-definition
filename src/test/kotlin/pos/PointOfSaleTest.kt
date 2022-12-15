package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {
        val pos = PointOfSale()

        val result = pos.scan("901234")

        assertThat(result.display()).isEqualTo("1.50")
    }

    @Test
    fun `When a scanned product is not present, a message 'invalid product' is displayed`() {
        val pos = PointOfSale()

        val result = pos.scan("101234")

        assertThat(result.display()).isEqualTo("invalid product")
    }
}
