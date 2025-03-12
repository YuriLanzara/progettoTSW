package model.dao;

import model.Order;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class OrderDAO {

    public static void saveOrder(Order order) {
        String sqlOrder = "INSERT INTO orders (user, status) VALUES (?, ?)";
        String sqlOrderItem = "INSERT INTO order_items (order_id, product_id, price_snapshot) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement psOrder = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
            psOrder.setString(1, order.getUser());
            psOrder.setString(2, order.getStatus());
            psOrder.executeUpdate();
            try (ResultSet rs = psOrder.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    order.setId(orderId);
                    try (PreparedStatement psItem = con.prepareStatement(sqlOrderItem)) {
                        for (Product p : order.getProducts()) {
                            psItem.setInt(1, orderId);
                            psItem.setInt(2, p.getId());
                            psItem.setDouble(3, p.getPrice()); // Prezzo al momento dell'acquisto
                            psItem.executeUpdate();
                        }
                    }
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Order findById(int id) {
        Order order = null;
        String sqlOrder = "SELECT * FROM orders WHERE id = ?";
        String sqlItems = "SELECT p.id, p.name, p.price, p.description, oi.price_snapshot FROM order_items oi JOIN products p ON oi.product_id = p.id WHERE oi.order_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement psOrder = con.prepareStatement(sqlOrder)) {
            psOrder.setInt(1, id);
            try (ResultSet rsOrder = psOrder.executeQuery()) {
                if(rsOrder.next()){
                    order = new Order();
                    order.setId(rsOrder.getInt("id"));
                    order.setUser(rsOrder.getString("user"));
                    order.setStatus(rsOrder.getString("status"));
                    List<Product> products = new ArrayList<>();
                    try (PreparedStatement psItems = con.prepareStatement(sqlItems)) {
                        psItems.setInt(1, id);
                        try (ResultSet rsItems = psItems.executeQuery()) {
                            while(rsItems.next()){
                                Product p = new Product(
                                    rsItems.getInt("id"),
                                    rsItems.getString("name"),
                                    rsItems.getDouble("price_snapshot"),
                                    rsItems.getString("description")
                                );
                                products.add(p);
                            }
                        }
                    }
                    order.setProducts(products);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    
    public static void updateOrder(Order order) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, order.getStatus());
            ps.setInt(2, order.getId());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
