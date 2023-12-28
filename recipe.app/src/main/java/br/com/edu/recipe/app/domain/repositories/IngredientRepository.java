/* (C)2023 */
package br.com.edu.recipe.app.domain.repositories;

import br.com.edu.recipe.app.domain.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {}
