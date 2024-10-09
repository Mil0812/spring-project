package mil0812.web_pr2_spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import mil0812.web_pr2_spring.config.AppConfig;
import mil0812.web_pr2_spring.entities.Cart;
import mil0812.web_pr2_spring.entities.Product;
import mil0812.web_pr2_spring.services.CartService;
import mil0812.web_pr2_spring.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = AppConfig.class)
class WebPr2SpringApplicationTests {
	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	private Cart cart;

	@BeforeEach
	void setUp() {
		cart = cartService.getNewCart();
	}

	@Test
	void testCreatedProducts() {
		assertEquals(5, productService.getProductList().size());
	}

	@Test
	void testAddProductToCart() {
		Product product = productService.getProductById(1L);
		cartService.addProduct(cart, product, 2);

		assertTrue(cart.getCartMap().containsKey(product));
	}

	@Test
	void testAddProductById() {
		cartService.addProduct(cart, 1L, 3);
		assertTrue(cart.getCartMap().containsKey(productService.getProductById(1L)));
	}

	@Test
	void testQuantity() {
		cartService.addProduct(cart, 1L, 3);
		cartService.addProduct(cart, 3L, 4);

		Integer quantityInCart = cart.getCartMap().get(productService.getProductById(1L)) +
				cart.getCartMap().get(productService.getProductById(3L));
		assertEquals(7, quantityInCart);
	}

	@Test
	void testDeleteProductFromCart() {
		Product product = productService.getProductById(1L);
		cartService.addProduct(cart, product, 1);

		cartService.delProduct(cart, product, 1);
		cartService.printCart(cart);
		assertFalse(cart.getCartMap().containsKey(product));
	}

	@Test
	void testDeleteFewProducts() {
		Product product = productService.getProductById(1L);
		cartService.addProduct(cart, product, 5);

		cartService.delProduct(cart, product, 3);
		assertEquals(2, cartService.getProductQuantity(cart, product));
	}

	@Test
	void testCartTotalSum() {
		Product product1 = productService.getProductById(1L);
		Product product2 = productService.getProductById(2L);

		cartService.addProduct(cart, product1, 2);
		cartService.addProduct(cart, product2, 3);

		BigDecimal expectedSum = product1.getPrice().multiply(BigDecimal.valueOf(2))
				.add(product2.getPrice().multiply(BigDecimal.valueOf(3)));

		assertEquals(expectedSum, cartService.getSum(cart));
	}

}
