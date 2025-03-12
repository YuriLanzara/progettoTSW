package model.dao;

import model.Promotion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class PromotionDAO {

    public static void insert(Promotion promo) {
        String sql = "INSERT INTO promotions (title, description, discount) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, promo.getTitle());
            ps.setString(2, promo.getDescription());
            ps.setDouble(3, promo.getDiscount());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Promotion> getAllPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        String sql = "SELECT * FROM promotions";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                promotions.add(new Promotion(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDouble("discount")
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }
}
