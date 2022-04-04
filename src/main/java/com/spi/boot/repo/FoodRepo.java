package com.spi.boot.repo;

import org.springframework.data.repository.CrudRepository;

import com.spi.boot.entity.Food;

public interface FoodRepo extends CrudRepository<Food, Integer> {

	public Food findFoodById(int id);
}
