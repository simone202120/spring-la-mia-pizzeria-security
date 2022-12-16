package org.pizzeria.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.pizzeria.italy.demo.pojo.Ingredient;
import org.pizzeria.italy.demo.repo.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ingredientiService {

	@Autowired
	private IngredientRepo ingredientRepo;
	
	public void save(Ingredient i) {
		ingredientRepo.save(i);
	}
	
	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}
	
	public Optional<Ingredient> getIngredientById(int id) {
		return ingredientRepo.findById(id);
	}
	
	public void deleteIngredientById(int id) {
		ingredientRepo.deleteById(id);
	}
	
	@Transactional
	public List<Ingredient> findAllWPizza() {
		List<Ingredient> ingredienti = ingredientRepo.findAll();
		
		for (Ingredient i : ingredienti) {
			Hibernate.initialize(i.getPizzas());
		}
		
		return ingredienti;
		
	}
}