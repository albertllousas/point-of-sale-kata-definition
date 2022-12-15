package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {

        val result = PointOfSale().scan(PointOfSale.ProductId(123456))

        assertThat(result).isEqualTo(PointOfSale.Display("1.50"))
    }



}
