package br.com.edu.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edu.start.model.Address;

/**
 * Repository to clients.
 *
 * @author Eduardo
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findAddressById(final long id);

}