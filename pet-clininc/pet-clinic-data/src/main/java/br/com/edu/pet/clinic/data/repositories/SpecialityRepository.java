package br.com.edu.pet.clinic.data.repositories;

import br.com.edu.pet.clinic.data.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
