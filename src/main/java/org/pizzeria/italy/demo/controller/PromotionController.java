package org.pizzeria.italy.demo.controller;

import java.util.List;

import org.pizzeria.italy.demo.pojo.Pizza;
import org.pizzeria.italy.demo.pojo.Promozioni;
import org.pizzeria.italy.demo.service.PizzaService;
import org.pizzeria.italy.demo.service.PromozioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/promozione")
public class PromotionController {
	
	@Autowired
	private PromozioniService PromozioneService;
	
	@Autowired 
	private PizzaService pzService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Promozioni> promotions = PromozioneService.findAllPizza();
		model.addAttribute("promotions", promotions);
		return "promotion-index";
	}
	
	@GetMapping("/create")
	public String getPromotionCreate(Model model) {
		
		Promozioni promozione = new Promozioni();
		List<Pizza> pizzas = pzService.findAll();
		model.addAttribute("promozioni", promozione);
		model.addAttribute("pizzas", pizzas);
		
		return "promotion-create";
	}
	
	@PostMapping("/create")
	public String storePromotion(@Valid Promozioni promozioni) {
		List<Pizza> promotionPizzas = promozioni.getPizzas();
		for (Pizza pizza : promotionPizzas) {
			pizza.setPromozioni(promozioni);
		}
		PizzaService.save(promozioni);
		
		return "redirect:/promotion";
	}
}
