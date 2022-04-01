package br.com.edu.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edu.start.model.Client;

/**
 * Repository to clients.
 *
 * @author Eduardo
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	/**
	 * Recupera clientes pelo nome.
	 *
	 * @param pNomeCli
	 * 
	 * @return
	 */
	Client findClienteByNomeCli(final String pNomeCli);

	<S extends Client> S save(Client client);

}