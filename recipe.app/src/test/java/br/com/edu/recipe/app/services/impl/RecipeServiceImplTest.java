/* (C)2023 */
package br.com.edu.recipe.app.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import br.com.edu.recipe.app.domain.model.Recipe;
import br.com.edu.recipe.app.domain.repositories.IngredientRepository;
import br.com.edu.recipe.app.domain.repositories.NotesRepository;
import br.com.edu.recipe.app.domain.repositories.RecipeRepository;
import br.com.edu.recipe.app.domain.services.impl.RecipeServiceImpl;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
