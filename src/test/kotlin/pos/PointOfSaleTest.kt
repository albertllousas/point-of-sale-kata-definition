package pos

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PointOfSaleTest {

    @Test
    fun `when a product is scanned, the price is displayed`() {

        val result = PointOfSale().scan(PointOfSale.ProductId("123456"))

        assertThat(result).isEqualTo(PointOfSale.Display("1.50"))
    }

    @Test
    fun `when a scanned product is not present, a message 'invalid product' is displayed`() {
        val result = PointOfSale().scan(PointOfSale.ProductId("654322"))

        assertThat(result).isEqualTo(PointOfSale.Display("invalid product"))
    }

    @Test
    fun `when several products are scanned, a shopping cart should contain them all`() {
        val pointOfSale = PointOfSale()
        val productList = listOf(PointOfSale.ProductId("123456"),
                                PointOfSale.ProductId("654321"),
                                PointOfSale.ProductId("123456"))

        pointOfSale.scan(PointOfSale.ProductId("123456"))
        pointOfSale.scan(PointOfSale.ProductId("654321"))
        pointOfSale.scan(PointOfSale.ProductId("123456"))

        assertThat(pointOfSale.listProducts()).isEqualTo(productList)
    }



}
