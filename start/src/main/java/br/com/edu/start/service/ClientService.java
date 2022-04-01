package br.com.edu.start.service;

import static br.com.edu.start.message.AppMessages.INFO_MANDATORY_FIELDS;
import static br.com.edu.start.message.AppMessages.RECORD_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.edu.start.AppException;
import br.com.edu.start.coverter.ClientConverter;
import br.com.edu.start.model.Client;
import br.com.edu.start.repository.ClientRepository;
import br.com.edu.start.util.StringUtils;

/**
 * The Business layer to client.
 * 
 * @author Eduardo
 */
@Controller
public class ClientService {

	@Autowired
	private ClientRepository repository;

	/**
	 * New instance to ClientService.
	 */
	public ClientService() {
		// NA
	}

	/**
	 * New instance to ClientService.
	 * 
	 * @param clientesRespository
	 */
	public ClientService(final ClientRepository clientesRespository) {
		this.repository = clientesRespository;
	}

	/**
	 * Save the client.
	 * 
	 * @param client
	 * 
	 * @return
	 * 
	 * @throws AppException
	 */
	public Client save(final ClientDTO client) throws AppException {
		validate(client);

		return repository.save(ClientConverter.toModel(client));
	}

	/**
	 * Valida the client.
	 * 
	 * @param client
	 * 
	 * @return
	 * 
	 * @throws AppException
	 */
	public void validate(final ClientDTO client) throws AppException {

		final List<String> invalidParameters = new ArrayList<>();

		if (client == null) {
			throw new AppException(INFO_MANDATORY_FIELDS, "client");
		}

		if (StringUtils.isNullOrEmpty(client.getNomeCli())) {
			invalidParameters.add("nomeCli");
		}

		if (StringUtils.isNullOrEmpty(client.getCidadeNasc())) {
			invalidParameters.add("cidadeNasc");
		}

		if (!invalidParameters.isEmpty()) {
			throw new AppException(INFO_MANDATORY_FIELDS, invalidParameters.toString());
		}

	}

	/**
	 * Get the client by id.
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @throws AppException
	 */
	public Client get(final Integer id) throws AppException {

		final Optional<Client> findById = repository.findById(id);

		return findById.orElseThrow(() -> new AppException(RECORD_NOT_FOUND));
	}

}