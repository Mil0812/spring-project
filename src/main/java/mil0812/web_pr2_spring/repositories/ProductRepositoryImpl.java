package mil0812.web_pr2_spring.repositories;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mil0812.web_pr2_spring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

  private final Map<Long, Product> productMap = new HashMap<>();

  @PostConstruct
  public void addProducts(){
    saveOrUpdate(new Product(1L, "Book \"Anne of Green Gables\"", BigDecimal.valueOf(243.7)));
    saveOrUpdate(new Product(2L, "Book \"Pollyanna\"", BigDecimal.valueOf(171.0)));
    saveOrUpdate(new Product(3L, "Book \"Sherlock Holmes\"", BigDecimal.valueOf(496.5)));
    saveOrUpdate(new Product(4L, "Set of books \"The secret diaries of Ulysses Moore\"", BigDecimal.valueOf(1728.0)));
    saveOrUpdate(new Product(5L, "Book \"Treasure Island\"", BigDecimal.valueOf(702.0)));
  }

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(productMap.values());
  }

  @Override
  public void saveOrUpdate(Product product) {
    productMap.put(product.getId(), product);
  }

  @Override
  public Product findById(Long id) {
    return productMap.get(id);
  }

  @Override
  public void deleteById(Long id) {
    productMap.remove(id);
  }
}
