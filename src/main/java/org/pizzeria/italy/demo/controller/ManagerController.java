package org.pizzeria.italy.demo.controller;

import java.util.List;

import org.pizzeria.italy.demo.pojo.Drink;
import org.pizzeria.italy.demo.pojo.Pizza;
import org.pizzeria.italy.demo.service.DrinkService;
import org.pizzeria.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/available")
public class ManagerController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DrinkService drinkServ;
	
	@GetMapping
	public String getAllByName(Model model, 
			@RequestParam(name = "query", required = false) String query) {
		
		List<Pizza> pizzas = null;
		List<Drink> drinks = null;
		
		if (query == null || query.isEmpty()) {
			
			pizzas = pizzaService.findAll();
			drinks = drinkServ.findAll();
		} else {
			
			pizzas = pizzaService.findByName(query);
			drinks = drinkServ.findByName(query);
		}
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
		
		return "available-search";
	}
}