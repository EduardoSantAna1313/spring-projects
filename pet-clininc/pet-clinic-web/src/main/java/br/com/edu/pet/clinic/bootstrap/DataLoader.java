/**
 *
 */
package br.com.edu.pet.clinic.bootstrap;

import java.time.LocalDate;

import br.com.edu.pet.clinic.data.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.model.Pet;
import br.com.edu.pet.clinic.data.model.PetType;
import br.com.edu.pet.clinic.data.model.Speciality;
import br.com.edu.pet.clinic.data.model.Vet;
import br.com.edu.pet.clinic.data.model.Visit;

/**
 * Data Loader.
 *
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetService petService;

    private final PetTypeService petTypeService;

    private final SpecialityService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(final String... args) throws Exception {

        final var count = petTypeService.findAll().size();

        if (count == 0) {
            loadMockData();
        }

    }

    /**
     *
     */
    private void loadMockData() {
        final PetType dog = new PetType();
        dog.setName("Dog");
        final PetType savedDogPetType = petTypeService.save(dog);

        final PetType cat = new PetType();
        cat.setName("Cat");
        final PetType savedCatPetType = petTypeService.save(cat);

        final Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        final Speciality savedRadiology = specialtyService.save(radiology);

        final Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        final Speciality savedSurgery = specialtyService.save(surgery);

        final Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        final Speciality savedDentistry = specialtyService.save(dentistry);

        final var owner1 = new Owner();
        owner1.setFirstName("Bart");
        owner1.setLastName("Simpson");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Springfield");
        owner1.setTelephone("1231231234");

        ownerService.save(owner1);

        final Pet bartsPet = new Pet();
        bartsPet.setPetType(savedDogPetType);
        bartsPet.setOwner(owner1);
        bartsPet.setBirthDate(LocalDate.now());
        bartsPet.setName("Santas little helper");
        owner1.getPets().add(bartsPet);

        petService.save(bartsPet);

        final var owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");
        owner2.setAddress("Springfield");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        ownerService.save(owner2);

        final Pet lisasCat = new Pet();
        lisasCat.setName("Snowball V");
        lisasCat.setOwner(owner2);
        lisasCat.setBirthDate(LocalDate.now());
        lisasCat.setPetType(savedCatPetType);
        owner2.getPets().add(lisasCat);

        petService.save(lisasCat);

        System.out.println("Loaded owners!");

        final Visit catVisit = new Visit();
        catVisit.setPet(lisasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        final var vet1 = new Vet();
        vet1.setFirstName("Marge");
        vet1.setLastName("Simpson");
        vetService.save(vet1);

        final var vet2 = new Vet();
        vet2.setFirstName("Homer");
        vet2.setLastName("Simpson");
        vetService.save(vet2);

        System.out.println("Loaded vets!");
    }

}
