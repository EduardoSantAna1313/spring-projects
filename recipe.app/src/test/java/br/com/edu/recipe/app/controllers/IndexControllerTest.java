package br.com.edu.recipe.app.controllers;

import br.com.edu.recipe.app.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

        final var result = indexController.index(model);

        assertEquals("index", result);
        verify(recipeService, times(1)).listAll();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}