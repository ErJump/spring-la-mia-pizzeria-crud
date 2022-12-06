package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
	
	@Autowired
	private DrinkRepo drinkRepo;
	
	public void save(Drink drink) {
		drinkRepo.save(drink);
	}
	
	public List<Drink> findAll() {
		return drinkRepo.findAll();
	}
}
