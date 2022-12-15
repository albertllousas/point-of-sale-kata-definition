package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pos.model.Product
import pos.model.ShoppingCart
import java.math.BigDecimal

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {
        val pos = PointOfSale()

        val result = pos.scan("901234")

        assertThat(result.display()).isEqualTo("1.50")
    }

    @Test
    fun `when a scanned product is not present, a message 'invalid product' is displayed`() {
        val pos = PointOfSale()

        val result = pos.scan("101234")

        assertThat(result.display()).isEqualTo("invalid product")
    }

    @Test
    fun `when a product is scanned successfully, it will be added to the current digital shopping cart`() {
        val pos = PointOfSale()

        pos.scan("901234")

        val expected = ShoppingCart(listOf(Product("901234", BigDecimal.valueOf(1.50), "Chips")))
        assertThat(pos.shoppingCart).isEqualTo(expected)
    }
}
