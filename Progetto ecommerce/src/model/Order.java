package model;

import java.util.List;

public class Order {
    private int id;
    private String user;
    private List<Product> products;
    private String status;
    
    public Order() { }
    
    public Order(int id, String user, List<Product> products, String status) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.status = status;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
