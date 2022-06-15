package br.com.edu.pet.clinic.data.model;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class PetType extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * Retrieve the value of name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new value to name.
     *
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

}
