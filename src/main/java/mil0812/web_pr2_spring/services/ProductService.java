package mil0812.web_pr2_spring.services;

import java.util.List;
import mil0812.web_pr2_spring.entities.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
  List<Product> getProductList();
  void saveOrUpdate(Product product);
  Product getProductById(Long id);
  void deleteById(Long id);

}
