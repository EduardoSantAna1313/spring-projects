package br.com.edu.start.service;

import static br.com.edu.start.message.AppMessages.INFO_MANDATORY_FIELDS;
import static br.com.edu.start.message.AppMessages.RECORD_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.start.AppException;
import br.com.edu.start.coverter.ClientConverter;
import br.com.edu.start.model.Address;
import br.com.edu.start.model.Client;
import br.com.edu.start.repository.AddressRepository;
import br.com.edu.start.repository.ClientRepository;
import br.com.edu.start.util.StringUtils;

/**
 * The Business layer to client.
 * 
 * @author Eduardo
 */
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientesRespository;

	@Autowired
	private AddressRepository addressRespository;

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
	public ClientService(final ClientRepository clientesRespository, final AddressRepository addressRespository) {
		this.clientesRespository = clientesRespository;
		this.addressRespository = addressRespository;
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
	@Transactional
	public Client save(final ClientDTO client) throws AppException {
		validate(client);

		return clientesRespository.save(ClientConverter.toModel(client));

	}

	@Transactional(rollbackFor = {
		AppException.class
	})
	public Client saveWithTransaction(final ClientDTO client, final List<Address> address) throws AppException {
		validate(client);

		final Client save = clientesRespository.save(ClientConverter.toModel(client));

		address.stream().forEach(a -> {
			a.setClientId(save.getCodCli());
			a.setCity(null);
		});

		try {
			addressRespository.saveAll(address);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return save;
	}

	@Transactional
	public Client saveWithoutTransaction(final ClientDTO client, final List<Address> address) throws AppException {
		validate(client);

		final Client save = clientesRespository.save(ClientConverter.toModel(client));

		address.stream().forEach(a -> a.setClientId(save.getCodCli()));

		saveAddress(address);

		return save;
	}

	@Transactional
	public void saveAddress(List<Address> address) {
		addressRespository.saveAll(address);
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

		final Optional<Client> findById = clientesRespository.findById(id);

		return findById.orElseThrow(() -> new AppException(RECORD_NOT_FOUND));
	}

	/**
	 * List all clients.
	 * 
	 * @return
	 */
	public List<Client> list() {
		return clientesRespository.findAll();
	}

}