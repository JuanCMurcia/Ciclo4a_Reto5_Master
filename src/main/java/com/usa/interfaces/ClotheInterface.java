package com.usa.interfaces;

import com.usa.model.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ClotheInterface extends MongoRepository<Clothe, String> {

    List<Clothe> findByPrice(Double price);

    List<Clothe> findByDescription(String description);
}
