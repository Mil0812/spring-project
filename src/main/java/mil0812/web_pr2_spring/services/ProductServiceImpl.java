package mil0812.web_pr2_spring.services;

import java.util.List;
import mil0812.web_pr2_spring.entities.Product;
import mil0812.web_pr2_spring.repositories.ProductRepository;
import mil0812.web_pr2_spring.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
  List<Product> listOfProducts;
  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getProductList() {
    return productRepository.findAll();
  }

  @Override
  public void saveOrUpdate(Product product) {
    productRepository.saveOrUpdate(product);
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
