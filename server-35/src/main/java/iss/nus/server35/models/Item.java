package iss.nus.server35.models;

public class Item {

    private String name;
    private Integer quantity;

    @Override
    public String toString() {
        return "Item [name=" + name + ", quantity=" + quantity + "]";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
