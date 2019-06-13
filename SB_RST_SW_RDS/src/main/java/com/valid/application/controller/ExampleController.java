package com.valid.application.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.valid.application.model.ExampleModel;
import com.valid.application.repository.ExampleRepository;


@RestController
public class ExampleController {

	private ExampleRepository exampleRepository;

    public ExampleController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @GetMapping("/addItem/{id}")
    public ExampleModel addItem(@PathVariable("id") final int id) {
    	exampleRepository.addItem(new ExampleModel(id));
        return exampleRepository.findById(id);
    }

    @GetMapping("/updateItem/{id}")
    public ExampleModel updateItem(@PathVariable("id") final int id) {
    	exampleRepository.updateItem(new ExampleModel(id));
        return exampleRepository.findById(id);
    }

    @GetMapping("/deleteItem/{id}")
    public Map<String, ExampleModel> deleteItem(@PathVariable("id") final int id) {
    	exampleRepository.deleteItem(id);
        return all();
    }

    @GetMapping("/allItems")
    public Map<String, ExampleModel> all() {
        return exampleRepository.findAllItems();
    }
	
}
