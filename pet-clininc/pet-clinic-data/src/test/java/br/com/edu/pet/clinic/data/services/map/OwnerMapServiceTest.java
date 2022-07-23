package br.com.edu.pet.clinic.data.services.map;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    public static final long OWNER_ID = 1l;

    private final String lastName = "Lee";

    OwnerMapService ownerMapService;

    PetService petService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());
        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        var ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {

        var owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());

    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(2l).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(2l, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertNull(ownerMapService.findById(OWNER_ID));

    }

    @Test()
    void deleteById() {
        ownerMapService.deleteById(2l);

        assertNull(ownerMapService.findById(2l));
    }



    @Test
    void findByLastName() {

        var owner = ownerMapService.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());

    }
}