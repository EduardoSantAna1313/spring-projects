package br.com.edu.pet.clininc.data.model;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class Person extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    /**
     * Create a new instance of Person
     *
     */
    public Person() {
        super();
    }

    /**
     * Create a new instance of Person
     *
     * @param firstName
     * @param lastName
     */
    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieve the value of firstName.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set a new value to firstName.
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieve the value of lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set a new value to lastName.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
