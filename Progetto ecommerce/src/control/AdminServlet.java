package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Product;
import model.dao.ProductDAO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica che l'amministratore sia autenticato
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("adminToken");
        if (token == null || !token.equals("tokenAdminValido")) {
            response.sendRedirect("admin/login.jsp?error=Accesso negato");
            return;
        }
        String action = request.getParameter("action");
        if ("addProduct".equals(action)) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            Product product = new Product(0, name, price, description);
            ProductDAO.insert(product);
            response.sendRedirect("admin/manageProducts.jsp?message=Prodotto aggiunto");
        } else if ("updateProduct".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            Product product = new Product(id, name, price, description);
            ProductDAO.update(product);
            response.sendRedirect("admin/manageProducts.jsp?message=Prodotto aggiornato");
        } else if ("deleteProduct".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDAO.delete(id);
            response.sendRedirect("admin/manageProducts.jsp?message=Prodotto eliminato");
        }
    }
}
