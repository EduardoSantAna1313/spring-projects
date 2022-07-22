package br.com.edu.pet.clinic.data.repositories;

import br.com.edu.pet.clinic.data.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
