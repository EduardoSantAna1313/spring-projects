/* (C)2023 */
package br.com.edu.recipe.app.domain.repositories;

import br.com.edu.recipe.app.domain.model.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
