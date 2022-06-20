package br.com.edu.recipe.app.repositories;

import br.com.edu.recipe.app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * @author eduardo
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public Set<Recipe> findAll();

}
