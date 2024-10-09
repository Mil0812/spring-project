package mil0812.web_pr2_spring.entities;

import java.math.BigDecimal;
import java.util.UUID;
import mil0812.web_pr2_spring.services.ProductService;
import org.springframework.stereotype.Component;

public class Product {
  private Long id;
  private String name;
  private BigDecimal price;

  public Product(Long id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
