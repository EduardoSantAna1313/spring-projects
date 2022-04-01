package br.com.edu.start.coverter;

import br.com.edu.start.model.Client;
import br.com.edu.start.service.ClientDTO;
import br.com.edu.start.util.ReflectionUtil;

/**
 * @author Eduardo
 */
public class ClientConverter {

	private ClientConverter() {
		// NA
	}

	public static ClientDTO toDTO(Client client) {
		final var bo = new ClientDTO();
		ReflectionUtil.copyObject(client, bo);
		return bo;
	}

	public static Client toModel(ClientDTO client) {
		final var model = new Client();
		ReflectionUtil.copyObject(client, model);
		return model;
	}

}
