/* (C)2023 */
package br.com.edu.recipe.app.domain.repositories;

import br.com.edu.recipe.app.domain.model.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
