package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Product;
import model.dao.ProductDAO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            try {
                int productId = Integer.parseInt(request.getParameter("productId"));
                Product product = ProductDAO.findById(productId);
                if (product != null) {
                    cart.add(product);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if ("remove".equals(action)) {
            try {
                int productId = Integer.parseInt(request.getParameter("productId"));
                cart.removeIf(p -> p.getId() == productId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if ("empty".equals(action)) {
            cart.clear();
        }
        session.setAttribute("cart", cart);
        // Risposta utile per aggiornamenti AJAX (numero di elementi nel carrello)
        response.getWriter().write(String.valueOf(cart.size()));
    }
}
