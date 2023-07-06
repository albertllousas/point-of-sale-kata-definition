package pos

import java.math.BigDecimal
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pos.PointOfSale.Product

class PointOfSaleTest {

    private val pointOfSale = PointOfSale(
        products = listOf(
            Product(productId = "123456", price = BigDecimal("12.50"), description = "laptop"),
            Product(productId = "121212", price = BigDecimal("99.99"), description = "iPhone"),
        )
    )

    @Test
    fun `should display product price when scanned`() {
        val result = pointOfSale.scan("123456")

        assertThat(result).isEqualTo(Display.Price(BigDecimal("12.50")))
    }

    @Test
    fun `should display invalid product message when scanned product is not found`() {
        val result = pointOfSale.scan("1234")

        assertThat(result).isEqualTo(Display.Error("invalid product"))
    }

    @Test
    fun `should add a product to the current digital shopping cart when scanned successfully`() {
        pointOfSale.scan("123456")
        pointOfSale.scan("121212")

        val result = pointOfSale.currentShoppingCart()

        assertThat(result).isEqualTo(listOf("123456", "121212"))
    }

    @Test
    fun `should remove product from shopping cart and display price in negative when added mistakenly`() {
        pointOfSale.scan("123456")
        pointOfSale.scan("121212")

        val result = pointOfSale.remove("123456")

        assertThat(result).isEqualTo(Display.Price(BigDecimal("-12.50")))
        assertThat(pointOfSale.currentShoppingCart()).isEqualTo(listOf("121212"))
    }

    @Test
    fun `should only remove one product if shopping cart contains the same product multiple times`() {
        pointOfSale.scan("123456")
        pointOfSale.scan("121212")
        pointOfSale.scan("121212")
        pointOfSale.remove("121212")

        val result = pointOfSale.currentShoppingCart()

        assertThat(result).isEqualTo(listOf("123456", "121212"))
    }

    @Test
    fun `should cancel the current sale in any moment, clearing out the cart`() {
        pointOfSale.scan("123456")
        pointOfSale.scan("121212")
        pointOfSale.scan("121212")

        pointOfSale.cancel()

        assertThat(pointOfSale.currentShoppingCart()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should check out and display the total price`() {
      pointOfSale.scan("123456")
      pointOfSale.scan("121212")

      val result = pointOfSale.checkOut()

      assertThat(result).isEqualTo(Display.Price(BigDecimal("112.49")))
    }
}
