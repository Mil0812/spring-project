package mil0812.web_pr2_spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"mil0812.web_pr2_spring.repositories",
"mil0812.web_pr2_spring.services",
"mil0812.web_pr2_spring.entities"})
    public class AppConfig {
}
