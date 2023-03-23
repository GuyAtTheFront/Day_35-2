package iss.nus.server35.services;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iss.nus.server35.models.Cart;
import iss.nus.server35.repositories.CartRepository;
import iss.nus.server35.utils.Utils;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepo;
    
    public Cart postCart(Cart cart) {

        String id = Utils.generateId();
        cart.setOrderId(id);

        Document doc = Document.parse(Utils.toJson(cart).toString());
        
        // TODO: fail to commit?
        cartRepo.insertCart(doc);

        return cart;
    }

}
