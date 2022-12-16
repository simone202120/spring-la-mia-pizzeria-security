package org.pizzeria.italy.demo.repo;

import org.pizzeria.italy.demo.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer>{

}
