package br.com.edu.pet.clinic.data.services.map;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.services.OwnerService;
import br.com.edu.pet.clinic.data.services.PetService;
import br.com.edu.pet.clinic.data.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;

    private final PetService petService;

    /**
     * Create a new instance of OwnerMapService
     *
     * @param petTypeService
     * @param petService
     */
    public OwnerMapService(final PetTypeService petTypeService, final PetService petService) {
        super();
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(final Owner object) {
        if (object != null) {

            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    petService.save(pet);
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() != null) {
                            petTypeService.save(pet.getPetType());
                        } else {
                            throw new RuntimeException("Pet type is required!");
                        }

                        if (pet.getId() == null) {
                            final var savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }

                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return this.findAll()
                .stream()
                .filter(o -> o.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

}
