package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Order;
import model.dao.OrderDAO;
import util.PaymentGateway;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderIdParam = request.getParameter("orderId");
        if(orderIdParam == null) {
            response.sendRedirect("jsp/orders.jsp?error=ID ordine mancante");
            return;
        }
        int orderId;
        try {
            orderId = Integer.parseInt(orderIdParam);
        } catch(NumberFormatException e) {
            response.sendRedirect("jsp/orders.jsp?error=ID ordine non valido");
            return;
        }
        Order order = OrderDAO.findById(orderId);
        if (order == null) {
            response.sendRedirect("jsp/orders.jsp?error=Ordine non trovato");
            return;
        }
        boolean paymentResult = PaymentGateway.processPayment(order);
        if (paymentResult) {
            order.setStatus("Pagato");
            OrderDAO.updateOrder(order);
            response.sendRedirect("jsp/payment.jsp?message=Pagamento avvenuto con successo");
        } else {
            response.sendRedirect("jsp/payment.jsp?error=Errore durante il pagamento");
        }
    }
}
