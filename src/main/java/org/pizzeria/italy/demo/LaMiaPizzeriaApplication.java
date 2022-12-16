package org.pizzeria.italy.demo;


import org.pizzeria.italy.demo.pojo.Pizza;

import java.util.List;

import org.pizzeria.italy.demo.pojo.Drink;
import org.pizzeria.italy.demo.service.DrinkService;
import org.pizzeria.italy.demo.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
     
@SpringBootApplication
public class LaMiaPizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	

	@Autowired
	private DrinkService drinkService;
	
	public static void main(String[] args) {
		SpringApplication.run(LaMiaPizzeriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("margherita", "mozzarella", 4300);
		Pizza p2 = new Pizza("diavola", null, 5000);
		Pizza p3 = new Pizza("bufala", "mozzarella bufala", 4400);
		Pizza p4 = new Pizza("olive", "olive ascolane", 7900);
	
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		
		
		Drink d1 = new Drink("rum&coca", "descrizione", 16700);
		Drink d2 = new Drink("negroni", "descrizione", 11400);
		Drink d3 = new Drink("spritz", "descrizione", 8007);
		
		
		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		
		List<Drink> drinks = drinkService.findAll();
		System.out.println(drinks);
	
		
	}
	
	
}
