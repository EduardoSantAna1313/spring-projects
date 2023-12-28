/* (C)2023 */
package br.com.edu.recipe.app.domain.services.impl;

import br.com.edu.recipe.app.domain.command.RecipeCommand;
import br.com.edu.recipe.app.domain.converter.RecipeCommandToRecipe;
import br.com.edu.recipe.app.domain.converter.RecipeToRecipeCommand;
import br.com.edu.recipe.app.domain.model.Recipe;
import br.com.edu.recipe.app.domain.repositories.IngredientRepository;
import br.com.edu.recipe.app.domain.repositories.NotesRepository;
import br.com.edu.recipe.app.domain.repositories.RecipeRepository;
import br.com.edu.recipe.app.domain.services.RecipeService;
import jakarta.transaction.Transactional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    private IngredientRepository ingredientRepository;

    private NotesRepository notesRepository;

    private RecipeCommandToRecipe recipeCommandToRecipe;
    private RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(
            RecipeRepository recipeRepository,
            IngredientRepository ingredientRepository,
            NotesRepository notesRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.notesRepository = notesRepository;
    }

    public RecipeCommandToRecipe getRecipeCommandToRecipe() {
        return recipeCommandToRecipe;
    }

    @Autowired
    public void setRecipeCommandToRecipe(RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Autowired
    public void setRecipeToRecipeCommand(RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    public Recipe save(final Recipe recipe) {

        log.debug("Saving the recipe {0}", recipe);

        recipeRepository.save(recipe);
        if (recipe.getIngredients() != null) {
            for (final var ingredient : recipe.getIngredients()) {
                ingredientRepository.save(ingredient);
            }
        }

        if (recipe.getNotes() != null) {
            notesRepository.save(recipe.getNotes());
        }

        return recipe;
    }

    public Set<Recipe> listAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe saved = recipeRepository.save(detachedRecipe);

        log.debug("Saved recipeId: " + saved.getId());

        return recipeToRecipeCommand.convert(saved);
    }
}
