package iss.nus.server35.utils;

import java.io.StringReader;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import iss.nus.server35.models.Cart;
import iss.nus.server35.models.Item;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {

    public static JsonObject toJson(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        return reader.readObject();
    }

    public static Cart toCart(JsonObject json) {
        
        //TODO: What if items is empty?
        List<Item> items = json.getJsonArray("items")
                                        .stream()
                                        .map(x -> Utils.toItem((JsonObject) x))
                                        .toList();

        Cart cart = new Cart();

        // cart.setOrderId(null);
        cart.setName(json.getString("name"));
        cart.setEmail(json.getString("email"));
        cart.setItems(items);

        return cart;
    }

    private static Item toItem(JsonObject json) {
        
        Item item = new Item();
        item.setName(json.getString("name"));
        item.setQuantity(json.getInt("quantity"));

        return item;
    }

    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public static JsonObject toJson(Cart cart) {
        
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        cart.getItems().forEach(x -> arrBuilder.add(Utils.toJson(x)));

        return Json.createObjectBuilder()
                .add("orderId", cart.getOrderId())
                .add("name", cart.getName())
                .add("email", cart.getEmail())
                .add("items", arrBuilder)
                .build();
    }

    private static JsonObject toJson(Item item) {
        return Json.createObjectBuilder()
                .add("name", item.getName())
                .add("quantity", item.getQuantity())
                .build();
    }
    
}
