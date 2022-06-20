package br.com.edu.recipe.app.repositories;

import br.com.edu.recipe.app.domain.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
