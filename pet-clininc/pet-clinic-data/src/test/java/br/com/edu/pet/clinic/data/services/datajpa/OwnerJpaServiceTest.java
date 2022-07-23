package br.com.edu.pet.clinic.data.services.datajpa;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.repositories.OwnerRepository;
import br.com.edu.pet.clinic.data.repositories.PetRepository;
import br.com.edu.pet.clinic.data.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTYpeRepository;

    @InjectMocks
    OwnerJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {

        Owner returnedOwner = Owner.builder().lastName(LAST_NAME).build();

        when(service.findByLastName(any())).thenReturn(returnedOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertNotNull(smith);
        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}