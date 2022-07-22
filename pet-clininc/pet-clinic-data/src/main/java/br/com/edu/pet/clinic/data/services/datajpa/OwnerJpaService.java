package br.com.edu.pet.clinic.data.services.datajpa;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.repositories.OwnerRepository;
import br.com.edu.pet.clinic.data.repositories.PetRepository;
import br.com.edu.pet.clinic.data.repositories.PetTypeRepository;
import br.com.edu.pet.clinic.data.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final PetRepository petRepository;

    private final PetTypeRepository petTYpeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTYpeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTYpeRepository = petTYpeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
           ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
          ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
