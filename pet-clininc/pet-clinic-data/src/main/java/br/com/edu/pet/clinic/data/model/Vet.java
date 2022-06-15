package br.com.edu.pet.clinic.data.model;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class Vet extends Person {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new instance of Vet
     *
     */
    public Vet() {
        super();
    }

    /**
     * Create a new instance of Vet
     *
     * @param firstName
     * @param lastName
     */
    public Vet(final String firstName, final String lastName) {
        super(firstName, lastName);
    }
}
