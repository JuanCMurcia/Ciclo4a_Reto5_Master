package com.usa.interfaces;

import com.usa.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserInterface extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User>findByBirthtDay(Date date);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User>findByMonthBirthtDay(String monthBirthtDay);

    List<User>findOneByOrderByIdDesc();

    Optional<User> findTopByOrderByIdDesc();
}
