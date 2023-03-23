package iss.nus.server35.models;

import java.util.List;

public class Cart {
    
    private String name;
    private String email;
    private List<Item> items;
    private String orderId;
    
    @Override
    public String toString() {
        return "Cart [name=" + name + ", email=" + email + ", items=" + items + ", orderId=" + orderId + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    

}
