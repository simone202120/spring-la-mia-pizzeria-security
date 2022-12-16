package org.pizzeria.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.pizzeria.italy.demo.pojo.Drink;
import org.pizzeria.italy.demo.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepo drinkRepo;
	
	public void save(Drink drink) {
		
		drinkRepo.save(drink);
	}
	public void delete(Drink drink) {
		
		drinkRepo.delete(drink);
	}
	public List<Drink> findAll() {
		
		return drinkRepo.findAll();
	}
	
	public Optional<Drink> findById(int id) {
		
		return drinkRepo.findById(id);
	}
	public List<Drink> findByName(String name) {
		
		return drinkRepo.findByNameContainingIgnoreCase(name);
	}
}
