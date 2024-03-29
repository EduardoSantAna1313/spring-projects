/* (C)2023 */
package br.com.edu.recipe.app.domain.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

    private Long id;

    private String description;
}
