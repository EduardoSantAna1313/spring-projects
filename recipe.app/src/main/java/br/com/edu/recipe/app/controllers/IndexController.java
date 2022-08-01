/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.recipe.app.controllers;

import br.com.edu.recipe.app.repositories.CategoryRepository;
import br.com.edu.recipe.app.repositories.UnitOfMeasureRepository;
import br.com.edu.recipe.app.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    private CategoryRepository categoryRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({ "/", "/index", "/index.html" })
    public String index(Model model) {

        log.debug("Getting index page....");

        //var category = categoryRepository.findByDescription("Mexican");

        //var unit = unitOfMeasureRepository.findByDescription("Ounce");

        var recipes = recipeService.listAll();

        model.addAttribute("recipes", recipes);

        return "index";
    }

}
