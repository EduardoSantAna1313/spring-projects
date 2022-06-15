/**
 *
 */
package br.com.edu.pet.clinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.model.Vet;
import br.com.edu.pet.clinic.data.services.OwnerService;
import br.com.edu.pet.clinic.data.services.VetService;

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

    /**
     * Create a new instance of DataLoader
     *
     * @param ownerService
     * @param vetService
     */
    public DataLoader(final OwnerService ownerService, final VetService vetService) {
        super();
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(final String... args) throws Exception {
        final var owner1 = new Owner();
        owner1.setFirstName("Bart");
        owner1.setLastName("Simpson");

        ownerService.save(owner1);

        final var owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");

        ownerService.save(owner2);

        System.out.println("Loaded owners!");

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
