package br.com.edu.pet.clinic.data.repositories;

import br.com.edu.pet.clinic.data.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
