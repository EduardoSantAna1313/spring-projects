/**
 *
 */
package br.com.pet.clinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.edu.pet.clininc.data.model.Owner;
import br.com.edu.pet.clininc.data.model.Vet;
import br.com.edu.pet.clininc.data.services.OwnerService;
import br.com.edu.pet.clininc.data.services.VetService;
import br.com.edu.pet.clininc.data.services.map.OwnerServiceMap;
import br.com.edu.pet.clininc.data.services.map.VetServiceMap;

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
//	private final PetService petService;

    /**
     * Create a new instance of DataLoader
     *
     */
    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(final String... args) throws Exception {
        final var owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Bart");
        owner1.setLastName("Simpson");

        ownerService.save(owner1);

        final var owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lisa");
        owner2.setLastName("Simpson");

        ownerService.save(owner2);

        System.out.println("Loaded owners!");

        final var vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Marge");
        vet1.setLastName("Simpson");
        vetService.save(vet1);

        final var vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Homer");
        vet2.setLastName("Simpson");
        vetService.save(vet2);

        System.out.println("Loaded vets!");

    }

}
