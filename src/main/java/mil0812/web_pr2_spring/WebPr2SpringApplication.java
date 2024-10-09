package mil0812.web_pr2_spring;

import java.util.List;
import mil0812.web_pr2_spring.config.AppConfig;
import mil0812.web_pr2_spring.entities.Product;
import mil0812.web_pr2_spring.repositories.ProductRepositoryImpl;
import mil0812.web_pr2_spring.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class WebPr2SpringApplication {

	public static void main(String[] args) {

		//екземпляр контексту Spring - створення ApplicationContext
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		//отримання біна ProductService зі Spring container
		ProductService productService = context.getBean(ProductService.class);

		String listOfProducts = "";
		List<Product> products = productService.getProductList();
		for(Product product : products){
			listOfProducts += product + "\n";
		}
		System.out.println(listOfProducts);
	}
}
