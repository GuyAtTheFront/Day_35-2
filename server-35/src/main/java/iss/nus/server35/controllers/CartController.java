package iss.nus.server35.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iss.nus.server35.models.Cart;
import iss.nus.server35.services.CartService;
import iss.nus.server35.utils.Utils;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/api/order", produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class CartController {

    @Autowired
    CartService cartService;
    
    @PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postCart(@RequestBody String payload) {

        // System.out.println(payload);

        JsonObject json = Utils.toJson(payload);
        Cart cart = Utils.toCart(json);
        
        // System.out.println(cart);
        cart = cartService.postCart(cart);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Utils.toJson(cart).toString());
    }

}
