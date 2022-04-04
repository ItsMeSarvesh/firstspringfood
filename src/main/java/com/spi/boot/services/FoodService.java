package com.spi.boot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spi.boot.entity.Food;
import com.spi.boot.repo.FoodRepo;

@Component
public class FoodService {

	@Autowired
	FoodRepo foodRepo;

	public List<Food> getAllFood() {
		return (List<Food>) foodRepo.findAll();
	}

	public Food getFoodById(int id) {
		return foodRepo.findFoodById(id);
	}

	public void addFood(Food f) {
		foodRepo.save(f);
	}

	public void addFoods(List<Food> l) {
		foodRepo.saveAll(l);
	}

	public Food deleteFood(int id) {
		Food f = foodRepo.findFoodById(id);
		foodRepo.delete(f);
		return f;
	}

	public Food updateFood(Food fNew, int id) {
		Food fOld = foodRepo.findFoodById(id);
		fOld.setName(fNew.getName());
		fOld.setTaste(fNew.getTaste());
		fOld.setQuantity(fNew.getQuantity());
		foodRepo.save(fOld);
		return fOld;
	}
}
