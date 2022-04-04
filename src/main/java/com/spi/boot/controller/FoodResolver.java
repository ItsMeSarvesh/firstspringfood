package com.spi.boot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spi.boot.entity.Food;
import com.spi.boot.entity.Users;
import com.spi.boot.services.FoodService;
import com.spi.boot.services.UserService;

@RestController
public class FoodResolver {

	@Autowired
	FoodService foodService;

	
	
//	--------------------------------------------------- Food -------------------------------------------------------------------
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getById(@PathVariable("id") int id) {
		Food f = null;
		try {
			f = foodService.getFoodById(id);
			return ResponseEntity.of(Optional.of(f));
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (NullPointerException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/food")
	public ResponseEntity<List<Food>> getAllFoodItems() {
		List<Food> list = foodService.getAllFood();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}
	}

	@PostMapping("/food")
	public ResponseEntity<Food> addFood(@RequestBody Food f) {
		foodService.addFood(f);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/foods")
	public ResponseEntity<List<Food>> addFoods(@RequestBody List<Food> l) {
		foodService.addFoods(l);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/food/{id}")
	public ResponseEntity<Void> deleteFood(@PathVariable("id") int id) {
		foodService.deleteFood(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/food/{id}")
	public ResponseEntity<Food> updateFood(@RequestBody Food food, @PathVariable("id") int id) {
		foodService.updateFood(food, id);
		return ResponseEntity.ok().build();
	}

}
