package comAbhimanyu.demo;

import comAbhimanyu.demo.DependencyInjection.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		// Start Spring Boot and create the IoC Container
		ApplicationContext context =
				SpringApplication.run(DemoApplication.class, args);

		// Get OrderService bean from the IoC Container
		OrderService orderService = context.getBean(OrderService.class);

		// Call the method
		orderService.placeOrder();
	}
}