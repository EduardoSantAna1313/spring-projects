package br.com.edu.pet.clinic.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Entity
@Table(name = "owners")
public class Owner extends Person {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

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

    /**
     * Retrieve the value of address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set a new value to address.
     *
     * @param address the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Retrieve the value of city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set a new value to city.
     *
     * @param city the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Retrieve the value of telephone.
     *
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set a new value to telephone.
     *
     * @param telephone the telephone to set
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retrieve the value of pets.
     *
     * @return the pets
     */
    public Set<Pet> getPets() {
        return pets;
    }

    /**
     * Set a new value to pets.
     *
     * @param pets the pets to set
     */
    public void setPets(final Set<Pet> pets) {
        this.pets = pets;
    }

}
