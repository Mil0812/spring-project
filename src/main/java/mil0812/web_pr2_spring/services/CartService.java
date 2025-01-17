package mil0812.web_pr2_spring.services;

import java.math.BigDecimal;
import mil0812.web_pr2_spring.entities.Cart;
import mil0812.web_pr2_spring.entities.Product;

public interface CartService {
  Cart getNewCart();
  void addProduct(Cart cart, Product product, Integer quantity);
  void addProduct(Cart cart, Long prodId, Integer quantity);
  void delProduct(Cart cart, Product product, Integer quantity);
  BigDecimal getSum(Cart cart);
  void printCart(Cart cart);
  int getProductQuantity(Cart cart, Product product);
  int getProductQuantity(Cart cart, Long prodId);
}
