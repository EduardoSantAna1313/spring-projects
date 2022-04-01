package br.com.edu.start.controller;

import java.util.Arrays;
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
 * RestControler para os Clientes.
 *
 * @author Eduardo
 */
@RestController
public class ClientesController {

	@Autowired
	private final ClientRepository clientesRespository;

	/**
	 * New instance to ClientesController.
	 * 
	 * @param clientesRespository
	 */
	public ClientesController(final ClientRepository clientesRespository) {
		this.clientesRespository = clientesRespository;
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
			final var business = new ClientService(clientesRespository);

			return ApiResponse.success(business.save(client));
		} catch (final AppException error) {
			return ApiResponse.error(error);
		}

	}

	/**
	 * List the clients.
	 *
	 * @return
	 * 
	 * @throws MessagingException
	 */
	@GetMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> get() {

		final List<Client> listClientes = clientesRespository.findAll();

		if (listClientes.isEmpty()) {

			Client c = new Client();
			c.setCidadeNasc("bla");
			return Arrays.asList(c);
		}

		return listClientes;
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
	public Client detail(@PathVariable Integer id) throws AppException {

		final var business = new ClientService(clientesRespository);

		try {
			return business.get(id);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Update the client
	 *
	 * @param obj
	 * 
	 * @return
	 */
	@PutMapping(value = "/put")
	public @ResponseBody ResponseEntity<String> atualizaCliente(@RequestBody final Client client) {
		return new ResponseEntity<>("PUT Response", HttpStatus.OK);
	}

}