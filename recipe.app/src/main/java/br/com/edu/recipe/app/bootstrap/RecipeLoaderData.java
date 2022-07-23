package br.com.edu.recipe.app.bootstrap;

import br.com.edu.recipe.app.domain.*;
import br.com.edu.recipe.app.repositories.UnitOfMeasureRepository;
import br.com.edu.recipe.app.services.CategoryService;
import br.com.edu.recipe.app.services.impl.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

@Slf4j
@Component
public class RecipeLoaderData implements CommandLineRunner {

    private RecipeServiceImpl recipeService;

    private CategoryService categoryService;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeLoaderData(RecipeServiceImpl recipeService, CategoryService categoryService, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureRepository = unitOfMeasureRepository;

        log.debug("Loading bootstrap data....");
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        grilledChickenTacos();
        perfectGuacamole();
    }

    private void grilledChickenTacos() {

        var tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        var pound = unitOfMeasureRepository.findByDescription("Pound").get();
        var unit = unitOfMeasureRepository.findByDescription("Unit").get();
        var clove = unitOfMeasureRepository.findByDescription("Clove").get();
        var cup = unitOfMeasureRepository.findByDescription("Cup").get();
        var slice = unitOfMeasureRepository.findByDescription("Slice").get();
        var liter = unitOfMeasureRepository.findByDescription("Liter").get();

        var mexican = categoryService.get("Mexican");

        var recipeChicken = new Recipe();
        recipeChicken.setDescription("Spicy Grilled Chicken Tacos");
        recipeChicken.addCategory(mexican);

        recipeChicken.setCookTime(15);
        recipeChicken.setPrepTime(20);
        recipeChicken.setServings(6);
        recipeChicken.setDifficulty(Difficulty.MODERATE);
        recipeChicken.setDirections("\n" +
                "Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                "Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        recipeChicken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        recipeChicken.setSource("simplyrecipes");
        recipeChicken.setNotes(new Notes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"));

        recipeChicken.addIngredient(getIngredient(2, "ancho chili powder", tablespoon));
        recipeChicken.addIngredient(getIngredient(1, "Dried oregano", tablespoon));
        recipeChicken.addIngredient(getIngredient(1, "Dried cumin", tablespoon));
        recipeChicken.addIngredient(getIngredient(1, "Sugar", tablespoon));
        recipeChicken.addIngredient(getIngredient(0.5, "Salt", tablespoon));
        recipeChicken.addIngredient(getIngredient(1, "Garlic", clove));
        recipeChicken.addIngredient(getIngredient(1, "Finely grated orange zest", tablespoon));
        recipeChicken.addIngredient(getIngredient(3, "Fresh-squeezed orange juice", tablespoon));
        recipeChicken.addIngredient(getIngredient(2, "Olive-oil", tablespoon));
        recipeChicken.addIngredient(getIngredient(4, "Skinless, boneless chicken thighs", pound));
        recipeChicken.addIngredient(getIngredient(8, "Small corn tortillas", unit));
        recipeChicken.addIngredient(getIngredient(3, "Packed baby arugula", cup));
        recipeChicken.addIngredient(getIngredient(2, "Medium ripe avocado", slice));
        recipeChicken.addIngredient(getIngredient(4, "Radishes, thinly sliced", slice));
        recipeChicken.addIngredient(getIngredient(0.5, "Cherry tomatoes, halved", liter));
        recipeChicken.addIngredient(getIngredient(0.25, "Red onion, thinly", unit));
        recipeChicken.addIngredient(getIngredient(1, "sour cream thinned with 1/4 cup milk", cup));
        recipeChicken.addIngredient(getIngredient(1, "lime, cut into wedges", unit));

        recipeService.save(recipeChicken);
    }

    private void perfectGuacamole() throws IOException {

        // Unit of measure
        var unit = unitOfMeasureRepository.findByDescription("Unit").get();
        var tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        var teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();


        // category
        var american = categoryService.get("American");

        // recipe
        var recipeChicken = new Recipe();
        recipeChicken.setDescription("Perfect Guacamole");
        recipeChicken.addCategory(american);

        recipeChicken.setCookTime(10);
        recipeChicken.setPrepTime(10);
        recipeChicken.setServings(4);
        recipeChicken.setDifficulty(Difficulty.EASY);
        recipeChicken.setDirections("Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "\n" +
                "Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "" +
                "Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days.\n" +
                "\n" +
                "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.");
        recipeChicken.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipeChicken.setSource("simplyrecipes");
        recipeChicken.setNotes(new Notes("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards."));

        recipeChicken.addIngredient(getIngredient(2, "Avocados", unit));
        recipeChicken.addIngredient(getIngredient(0.25, "kosher salt, plus more to taste", teaspoon));
        recipeChicken.addIngredient(getIngredient(4, "minced red onion or thinly sliced green onion", tablespoon));

        recipeService.save(recipeChicken);
    }

    private Ingredient getIngredient(double qty, String description, UnitOfMeasure uom) {
        Ingredient ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(qty));
        ingredient.setDescription(description);
        ingredient.setUnitOfMeasure(uom);
        return ingredient;
    }


}
