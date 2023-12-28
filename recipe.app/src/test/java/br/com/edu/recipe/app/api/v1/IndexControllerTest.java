/* (C)2023 */
package br.com.edu.recipe.app.api.v1;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import br.com.edu.recipe.app.domain.model.Recipe;
import br.com.edu.recipe.app.domain.services.RecipeService;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    public void index() {

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe r2 = new Recipe();
        r2.setId(2l);
        recipes.add(r2);

        when(recipeService.listAll()).thenReturn(recipes);

        final var result = indexController.index(model);

        assertEquals("index", result);
        verify(recipeService, times(1)).listAll();

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}
