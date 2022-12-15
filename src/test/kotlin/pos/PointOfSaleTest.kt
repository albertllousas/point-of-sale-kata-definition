package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {

        val result = PointOfSale().scan("901234")

        assertThat(result).isEqualTo("1.50")
    }
}
