package util;

import model.Order;

public class PaymentGateway {
    public static boolean processPayment(Order order) {
        // Simula l'elaborazione del pagamento; in un caso reale integrare un API di pagamento
        System.out.println("Elaborazione pagamento per l'ordine: " + order.getId());
        return true;
    }
}
