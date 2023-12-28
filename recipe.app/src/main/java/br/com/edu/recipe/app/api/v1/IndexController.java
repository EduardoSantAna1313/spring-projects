/* (C)2023 */
package br.com.edu.recipe.app.api.v1;

import br.com.edu.recipe.app.domain.repositories.CategoryRepository;
import br.com.edu.recipe.app.domain.repositories.UnitOfMeasureRepository;
import br.com.edu.recipe.app.domain.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    private CategoryRepository categoryRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String index(Model model) {

        log.debug("Getting index page....");

        // var category = categoryRepository.findByDescription("Mexican");

        // var unit = unitOfMeasureRepository.findByDescription("Ounce");

        var recipes = recipeService.listAll();

        model.addAttribute("recipes", recipes);

        return "index";
    }
}
