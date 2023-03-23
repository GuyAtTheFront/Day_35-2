package iss.nus.server35.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertCart(Document doc) {
        Document inserted = mongoTemplate.insert(doc, "orders");
        System.out.println(inserted);
    }
    
}
