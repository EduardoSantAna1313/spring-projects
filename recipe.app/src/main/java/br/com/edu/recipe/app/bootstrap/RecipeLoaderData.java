/* (C)2023 */
package br.com.edu.recipe.app.bootstrap;

import br.com.edu.recipe.app.domain.model.*;
import br.com.edu.recipe.app.domain.repositories.UnitOfMeasureRepository;
import br.com.edu.recipe.app.domain.services.CategoryService;
import br.com.edu.recipe.app.domain.services.impl.RecipeServiceImpl;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RecipeLoaderData implements CommandLineRunner {

    private RecipeServiceImpl recipeService;

    private CategoryService categoryService;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeLoaderData(
            RecipeServiceImpl recipeService,
            CategoryService categoryService,
            UnitOfMeasureRepository unitOfMeasureRepository) {
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

        var recipeGrilled = new Recipe();
        recipeGrilled.setDescription("Spicy Grilled Chicken Tacos");
        recipeGrilled.addCategory(mexican);

        recipeGrilled.setCookTime(15);
        recipeGrilled.setPrepTime(20);
        recipeGrilled.setServings(6);
        recipeGrilled.setDifficulty(Difficulty.MODERATE);
        recipeGrilled.setDirections(
                """
						Prepare a gas or charcoal grill for medium-high, direct heat
						Make the marinade and coat the chicken:
						In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.

						Set aside to marinate while the grill heats and you prepare the rest of the toppings.Grill the chicken:
						Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.

						Warm the tortillas:
						Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.

						Wrap warmed tortillas in a tea towel to keep them warm until serving.

						Assemble the tacos:
						Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.""");

        recipeGrilled.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        recipeGrilled.setSource("simplyrecipes");
        // recipeGrilled.setNotes(new Notes(
        //                "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it
        // online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2
        // 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"));

        // recipeGrilled.addIngredient(getIngredient(2, "ancho chili powder", tablespoon));
        /*recipeGrilled.addIngredient(getIngredient(1, "Dried oregano", tablespoon));
        recipeGrilled.addIngredient(getIngredient(1, "Dried cumin", tablespoon));
        recipeGrilled.addIngredient(getIngredient(1, "Sugar", tablespoon));
        recipeGrilled.addIngredient(getIngredient(0.5, "Salt", tablespoon));
        recipeGrilled.addIngredient(getIngredient(1, "Garlic", clove));
        recipeGrilled.addIngredient(getIngredient(1, "Finely grated orange zest", tablespoon));
        recipeGrilled.addIngredient(getIngredient(3, "Fresh-squeezed orange juice", tablespoon));
        recipeGrilled.addIngredient(getIngredient(2, "Olive-oil", tablespoon));
        recipeGrilled.addIngredient(getIngredient(4, "Skinless, boneless chicken thighs", pound));
        recipeGrilled.addIngredient(getIngredient(8, "Small corn tortillas", unit));
        recipeGrilled.addIngredient(getIngredient(3, "Packed baby arugula", cup));
        recipeGrilled.addIngredient(getIngredient(2, "Medium ripe avocado", slice));
        recipeGrilled.addIngredient(getIngredient(4, "Radishes, thinly sliced", slice));
        recipeGrilled.addIngredient(getIngredient(0.5, "Cherry tomatoes, halved", liter));
        recipeGrilled.addIngredient(getIngredient(0.25, "Red onion, thinly", unit));
        recipeGrilled.addIngredient(getIngredient(1, "sour cream thinned with 1/4 cup milk", cup));
        recipeGrilled.addIngredient(getIngredient(1, "lime, cut into wedges", unit));*/
        recipeService.save(recipeGrilled);
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
        recipeChicken.setDirections(
                """
						Cut the avocado:
						Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.

						Mash the avocado flesh:
						Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)
						Add the remaining ingredients to taste:
						Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.

						Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.

						Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.

						Serve immediately:
						If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)

						Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.

						Refrigerate leftover guacamole up to 3 days.

						Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.
						""");

        recipeChicken.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipeChicken.setSource("simplyrecipes");
        recipeChicken.setNotes(
                new Notes(
                        "Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards."));

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
