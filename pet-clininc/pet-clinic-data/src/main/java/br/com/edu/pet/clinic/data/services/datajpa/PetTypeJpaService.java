package br.com.edu.pet.clinic.data.services.datajpa;

import br.com.edu.pet.clinic.data.model.Pet;
import br.com.edu.pet.clinic.data.model.PetType;
import br.com.edu.pet.clinic.data.repositories.PetTypeRepository;
import br.com.edu.pet.clinic.data.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        final Set<PetType> types = new HashSet<>();
        petTypeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType type) {
        return petTypeRepository.save(type);
    }

    @Override
    public void delete(PetType type) {
        petTypeRepository.delete(type);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
