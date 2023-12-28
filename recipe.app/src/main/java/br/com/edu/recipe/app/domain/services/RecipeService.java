/* (C)2023 */
package br.com.edu.recipe.app.domain.services;

import br.com.edu.recipe.app.domain.command.RecipeCommand;
import br.com.edu.recipe.app.domain.model.Recipe;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> listAll();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
