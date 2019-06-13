package com.valid.application.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.valid.application.model.ExampleModel;

@Repository
public class ExampleRepository {

    private RedisTemplate<String, ExampleModel> redisTemplate;

    private HashOperations hashOperations;


    public ExampleRepository(RedisTemplate<String, ExampleModel> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    public void addItem(ExampleModel model) {
        hashOperations.put("USER", model.getId(), model);
    }

    public Map<String, ExampleModel> findAllItems() {
        return hashOperations.entries("USER");
    }

    public ExampleModel findById(int id) {
        return (ExampleModel)hashOperations.get("USER", id);
    }

    public void updateItem(ExampleModel model) {
    	addItem(model);
    }

    public void deleteItem(int id) {
        hashOperations.delete("USER", id);
    }
		
}
