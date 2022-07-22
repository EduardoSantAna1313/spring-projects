package br.com.edu.pet.clinic.data.services.map;

import br.com.edu.pet.clinic.data.model.Speciality;
import br.com.edu.pet.clinic.data.model.Vet;
import br.com.edu.pet.clinic.data.services.SpecialityService;
import br.com.edu.pet.clinic.data.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    /**
     * Create a new instance of VetServiceMap
     *
     * @param specialityService
     */
    public VetServiceMap(final SpecialityService specialityService) {
        super();
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(final Vet object) {

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(s -> {
                specialityService.save(s);

                if (s.getId() == null) {
                    final Speciality savedSpecialty = specialityService.save(s);
                    s.setId(savedSpecialty.getId());
                }

            });
        }

        return super.save(object);
    }

}
