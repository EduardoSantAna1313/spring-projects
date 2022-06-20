package br.com.edu.recipe.app.repositories;

import br.com.edu.recipe.app.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
