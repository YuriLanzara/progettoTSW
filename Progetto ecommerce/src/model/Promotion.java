package model;

public class Promotion {
    private int id;
    private String title;
    private String description;
    private double discount;
    
    public Promotion() { }
    
    public Promotion(int id, String title, String description, double discount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.discount = discount;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }
}
