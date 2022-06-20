package br.com.edu.recipe.app.services;

import br.com.edu.recipe.app.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    public Set<Recipe> listAll();
}
