package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pos.model.DisplayRecord
import pos.model.Product
import java.math.BigDecimal

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {
        val pos = PointOfSale()

        val product = pos.scan("901234")

        assertThat(product).isEqualTo(Product("901234", BigDecimal.valueOf(1.50), "Chips"))

        val display = pos.display(product)

        assertThat(display).isEqualTo(DisplayRecord("1.50"))
    }
}
