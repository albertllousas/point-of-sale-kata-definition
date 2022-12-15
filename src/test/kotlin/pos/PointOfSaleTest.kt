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

        val expected = ShoppingCart(mutableListOf(Product("901234", BigDecimal.valueOf(1.50), "Chips")))
        assertThat(pos.shoppingCart).isEqualTo(expected)
    }

    @Test
    fun `when two products are scanned, both are added to the same cart`() {
        val pos = PointOfSale()

        pos.scan("901234")
        pos.scan("507780")

        val expected = ShoppingCart(mutableListOf(
            Product("901234", BigDecimal.valueOf(1.50), "Chips"),
            Product("507780", BigDecimal.valueOf(2.35), "Red Bull")
        ))
        assertThat(pos.shoppingCart).isEqualTo(expected)
    }

    @Test
    fun `If a product was added by mistake, we can remove it from the current cart by product-id`() {
        val pos = PointOfSale()

        pos.scan("901234")
        val result = pos.remove("901234")

        assertThat(result.display()).isEqualTo("-1.50")
        assertThat(pos.shoppingCart).isEqualTo(ShoppingCart())
    }
}
