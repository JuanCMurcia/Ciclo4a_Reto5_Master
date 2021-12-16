package com.usa.repository;

import com.usa.interfaces.ClotheInterface;
import com.usa.model.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClotheRepository {

    @Autowired
    private ClotheInterface crudInterface;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Clothe> getAll() {
        return crudInterface.findAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return crudInterface.findById(reference);
    }

    public Clothe create(Clothe clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Clothe clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Clothe clothe) {
        crudInterface.delete(clothe);
    }

    public List<Clothe>findPrice(Double price){
        return crudInterface.findByPrice(price);
    }

    public List<Clothe>findByDescriptionLike(String keyword){
        Query query = new Query();
        Criteria keywordCriteria = Criteria.where("description").regex(".*"+keyword+".*","i");

        query.addCriteria(keywordCriteria);
        List<Clothe> clothes = mongoTemplate.find(query, Clothe.class);
        return clothes;
    }
}
