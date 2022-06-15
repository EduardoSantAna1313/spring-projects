package com.springframework.pets;

/**
 * Factory
 *
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class PetServiceFactory {

    public PetService getPetService(final String petType) {
        switch (petType) {
        case "dog":
            return new DogPetService();
        case "cat":
            return new CatPetService();
        default:
            return new DogPetService();
        }
    }

}
