package br.com.edu.recipe.app.services.impl;

import br.com.edu.recipe.app.domain.Recipe;
import br.com.edu.recipe.app.repositories.IngredientRepository;
import br.com.edu.recipe.app.repositories.NotesRepository;
import br.com.edu.recipe.app.repositories.RecipeRepository;
import br.com.edu.recipe.app.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    private IngredientRepository ingredientRepository;

    private NotesRepository notesRepository;


    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, NotesRepository notesRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.notesRepository = notesRepository;
    }

    public Recipe save(final Recipe recipe) {

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

}
