/* (C)2023 */
package br.com.edu.recipe.app.domain.command;

import br.com.edu.recipe.app.domain.model.Difficulty;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;

    private String description;

    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    private Set<IngredientCommand> ingredients = new HashSet<>();

    private Difficulty difficulty;

    private NotesCommand notes;

    private Set<CategoryCommand> categories = new HashSet<>();
}
