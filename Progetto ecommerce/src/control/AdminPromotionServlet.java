package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Promotion;
import model.dao.PromotionDAO;

@WebServlet("/AdminPromotionServlet")
public class AdminPromotionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("adminToken");
        if (token == null || !token.equals("tokenAdminValido")) {
            response.sendRedirect("login.jsp?error=Accesso negato");
            return;
        }
        String action = request.getParameter("action");
        if ("addPromotion".equals(action)) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            double discount = Double.parseDouble(request.getParameter("discount"));
            Promotion promo = new Promotion(0, title, description, discount);
            PromotionDAO.insert(promo);
            response.sendRedirect("managePromotions.jsp?message=Promozione aggiunta");
        } else if ("deletePromotion".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            // Se implementato: PromotionDAO.delete(id);
            response.sendRedirect("managePromotions.jsp?message=Promozione eliminata");
        }
    }
}
