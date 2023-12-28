/* (C)2023 */
package br.com.edu.recipe.app.domain.repositories;

import br.com.edu.recipe.app.domain.model.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {}
