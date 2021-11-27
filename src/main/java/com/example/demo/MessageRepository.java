package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message,Integer> {
    Iterable<Message> findAllByUserId(Integer user_id);

}
