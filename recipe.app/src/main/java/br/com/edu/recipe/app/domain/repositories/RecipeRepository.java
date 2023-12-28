/* (C)2023 */
package br.com.edu.recipe.app.domain.repositories;

import br.com.edu.recipe.app.domain.model.Recipe;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public Set<Recipe> findAll();
}
