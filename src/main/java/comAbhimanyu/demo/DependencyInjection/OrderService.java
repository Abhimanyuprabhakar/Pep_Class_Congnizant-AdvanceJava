package comAbhimanyu.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    // ----------------------------
    // Field Injection
    // ----------------------------
    @Autowired
    private PaymentService paymentService;

    // ----------------------------
    // Constructor Injection
    // ----------------------------
    @Autowired
    public OrderService(PaymentService paymentService) {
        System.out.println("Constructor Injection");
        this.paymentService = paymentService;
    }

    // ----------------------------
    // Setter Injection
    // ----------------------------
    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        System.out.println("Setter Injection");
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.payment();
        System.out.println("Order Placed Successfully");
    }
}