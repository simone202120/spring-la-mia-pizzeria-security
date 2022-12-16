package org.pizzeria.italy.demo.repo;

import org.pizzeria.italy.demo.pojo.Promozioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface promozioniRepo extends JpaRepository<Promozioni, Integer>{

}

