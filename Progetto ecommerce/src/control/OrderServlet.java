package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Order;
import model.Product;
import model.dao.OrderDAO;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("jsp/cart.jsp?error=Carrello vuoto");
            return;
        }
        Order order = new Order();
        order.setProducts(cart);
        order.setUser((String) session.getAttribute("username")); // Assicurarsi che l'utente sia autenticato
        order.setStatus("In elaborazione");
        OrderDAO.saveOrder(order);
        session.removeAttribute("cart");
        response.sendRedirect("jsp/orders.jsp?message=Ordine effettuato con successo");
    }
}
