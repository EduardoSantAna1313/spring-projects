package br.com.edu.recipe.app.controllers;

import br.com.edu.recipe.app.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String get(@PathVariable("id") Long id, Model model) {

        System.out.println("ID: " + id);

        final var recipe = recipeService.findById(id);

        model.addAttribute("recipe", recipe);

        return "recipe/show";
    }

}
