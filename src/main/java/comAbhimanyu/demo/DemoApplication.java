package comAbhimanyu.demo;

import comAbhimanyu.demo.DependencyInjection.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// Start Spring Boot and create the IoC Container
//		ApplicationContext context =
//				SpringApplication.run(DemoApplication.class, args);
//
//		// Get OrderService bean from the IoC Container
//		OrderService orderService = context.getBean(OrderService.class);
//
//		// Call the method
//		orderService.placeOrder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:63342")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}
}