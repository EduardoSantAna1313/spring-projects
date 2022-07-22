package br.com.edu.pet.clinic.data.repositories;

import br.com.edu.pet.clinic.data.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
