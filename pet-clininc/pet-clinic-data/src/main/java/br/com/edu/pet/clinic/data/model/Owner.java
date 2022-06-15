package br.com.edu.pet.clinic.data.model;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class Owner extends Person {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new instance of Owner
     */
    public Owner() {
        super();
    }

    /**
     * Create a new instance of Owner
     *
     * @param firstName
     * @param lastName
     */
    public Owner(final String firstName, final String lastName) {
        super(firstName, lastName);
    }
}
