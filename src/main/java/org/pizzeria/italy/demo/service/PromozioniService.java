package org.pizzeria.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.pizzeria.italy.demo.pojo.Promozioni;
import org.pizzeria.italy.demo.repo.promozioniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class PromozioniService {
	
	@Autowired
	private promozioniRepo promo;
	
	public void save(Promozioni  promozioni) {
		promo.save(promozioni);
	}
	
	public List<Promozioni> findAll() {
		return promo.findAll();
	}
	
	public Optional<Promozioni> getPromozioninById(int id) {
		return promo.findById(id);
	}
	
	public void deletePromozioniById(int id) {
		promo.deleteById(id);
	}
	
	@Transactional
	public List<Promozioni> findAllPizza() {
		List<Promozioni> promozioni = promo.findAll();
		
		for (Promozioni promozione : promozioni) {
			Hibernate.initialize(promozione.getPizzas());
		}
		
		return promozioni;
		
	}
	
}