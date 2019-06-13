package com.valid.application.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.valid.application.model.ExampleModel;
import com.valid.application.repository.ExampleRepository;
import io.swagger.annotations.ApiOperation;


@RestController
public class ExampleController {

	private ExampleRepository exampleRepository;

    public ExampleController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @ApiOperation(value = "addItem", notes = "This operation creates a new item", response = String.class)
    @GetMapping("/addItem/{id}")
    public ExampleModel addItem(@PathVariable("id") final int id) {
    	exampleRepository.addItem(new ExampleModel(id));
        return exampleRepository.findById(id);
    }

    @ApiOperation(value = "updateItem", notes = "This operation update a item", response = String.class)
    @GetMapping("/updateItem/{id}")
    public ExampleModel updateItem(@PathVariable("id") final int id) {
    	exampleRepository.updateItem(new ExampleModel(id));
        return exampleRepository.findById(id);
    }
    
    @ApiOperation(value = "deleteItem", notes = "This operation delete a item", response = String.class)
    @GetMapping("/deleteItem/{id}")
    public Map<String, ExampleModel> deleteItem(@PathVariable("id") final int id) {
    	exampleRepository.deleteItem(id);
        return all();
    }
    
    @ApiOperation(value = "getAllItems", notes = "This operation get all items", response = String.class)
    @GetMapping("/getAllItems")
    public Map<String, ExampleModel> all() {
        return exampleRepository.findAllItems();
    }
	
}
