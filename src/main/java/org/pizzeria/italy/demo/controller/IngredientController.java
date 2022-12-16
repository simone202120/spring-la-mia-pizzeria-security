package org.pizzeria.italy.demo.controller;


import java.util.List;

import org.pizzeria.italy.demo.pojo.Ingredient;
import org.pizzeria.italy.demo.pojo.Pizza;
import org.pizzeria.italy.demo.service.PizzaService;
import org.pizzeria.italy.demo.service.ingredientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredienti")
public class IngredientController {
	
	@Autowired
	private ingredientiService ingredientiService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Ingredient> ingredients = ingredientiService.findAllWPizza();
		model.addAttribute("ingredients", ingredients);
		return "ingredient-index";
	}
	
	@GetMapping("/create")
	public String getIngredientCreate(Model model) {
		
		Ingredient i = new Ingredient();
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("ingredient", i);
		model.addAttribute("pizzas", pizzas);
		return "ingredient-create";
	}
	
}
