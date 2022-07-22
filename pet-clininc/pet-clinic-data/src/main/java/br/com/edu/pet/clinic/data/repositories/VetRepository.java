package br.com.edu.pet.clinic.data.repositories;

import br.com.edu.pet.clinic.data.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
