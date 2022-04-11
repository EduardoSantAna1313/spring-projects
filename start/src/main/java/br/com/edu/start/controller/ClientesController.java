package br.com.edu.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.start.AppException;
import br.com.edu.start.model.Client;
import br.com.edu.start.repository.ClientRepository;
import br.com.edu.start.service.ClientDTO;
import br.com.edu.start.service.ClientService;

/**
 * RestControler to Clients.
 *
 * @author Eduardo
 */
@RestController
public class ClientesController {

	@Autowired
	private final ClientRepository clientRespository;

	/**
	 * New instance to ClientesController.
	 * 
	 * @param clientRespository
	 */
	public ClientesController(final ClientRepository clientRespository) {
		this.clientRespository = clientRespository;
	}

	/**
	 * Save the client
	 *
	 * @param client
	 * 
	 * @return
	 */
	@PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ApiResponse post(@RequestBody final ClientDTO client) {

		try {
			final var business = new ClientService(clientRespository);

			return ApiResponse.success(business.save(client));
		} catch (final AppException error) {

			return ApiResponse.error(error);
		}

	}

	/**
	 * List the clients.
	 *
	 * @return
	 */
	@GetMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> list() {
		final var business = new ClientService(clientRespository);

		return business.list();
	}

	/**
	 * Detail the client.
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @throws AppException
	 */
	@GetMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ApiResponse detail(@PathVariable Integer id) {

		final var business = new ClientService(clientRespository);

		try {
			return ApiResponse.success(business.get(id));
		} catch (final AppException error) {
			return ApiResponse.error(error);
		}

	}

	/**
	 * Update the client
	 *
	 * @param client
	 * 
	 * @return
	 */
	@PutMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> update(@RequestBody final ClientDTO client) {
		return new ResponseEntity<>("PUT Response", HttpStatus.OK);
	}

}