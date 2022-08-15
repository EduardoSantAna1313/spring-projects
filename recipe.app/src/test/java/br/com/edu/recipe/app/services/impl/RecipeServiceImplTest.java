package br.com.edu.recipe.app.services.impl;

import br.com.edu.recipe.app.domain.Recipe;
import br.com.edu.recipe.app.repositories.IngredientRepository;
import br.com.edu.recipe.app.repositories.NotesRepository;
import br.com.edu.recipe.app.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    IngredientRepository ingredientRepository;

    @Mock
    NotesRepository notesRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, ingredientRepository, notesRepository);
    }

    @Test
    public void listAll() {

        Recipe recipe = new Recipe();

        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.listAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.listAll();

        assertEquals(1, recipes.size());

        verify(recipeRepository, times(1)).findAll();
    }
}