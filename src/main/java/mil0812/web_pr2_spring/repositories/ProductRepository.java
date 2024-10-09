package mil0812.web_pr2_spring.repositories;

import java.util.List;
import mil0812.web_pr2_spring.entities.Product;

public interface ProductRepository {
  List<Product> findAll();
  void saveOrUpdate(Product product);
  Product findById(Long id);
  void deleteById(Long id);
}
