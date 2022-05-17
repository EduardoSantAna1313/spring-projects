/**
 * 
 */
package br.com.edu.start.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.edu.start.AppException;
import br.com.edu.start.model.Address;
import br.com.edu.start.repository.AddressRepository;
import br.com.edu.start.repository.ClientRepository;

/**
 * Tests to ClientService.
 * 
 * @author Eduardo
 */
@DataJpaTest
class ClientServiceTest {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AddressRepository addressRepository;

	ClientService service;

	@BeforeEach
	private void before() {
		service = new ClientService(clientRepository, addressRepository);
	}

	static {
		// force the locale
		Locale.setDefault(new Locale("pt", "BR"));
	}

	@Test
	void testErrorClientMandatoryPtBR() {

		try {
			service.save(null);
		} catch (AppException error) {
			assertEquals(error.getMessage(), "Parametros obrigatórios faltando: client.");
		}

	}

	@Test
	void testErrorClientMandatoryNomeCliPtBR() {

		try {
			final var client = mock(ClientDTO.class);
			when(client.getCidadeNasc()).thenReturn("Cidade");

			service.save(client);
		} catch (final AppException error) {
			assertEquals("Parametros obrigatórios faltando: [nomeCli].", error.getMessage());
		}

	}

	@Test
	void testErrorClientMandatoryCidadePtBR() {

		try {
			final var client = mock(ClientDTO.class);
			when(client.getNomeCli()).thenReturn("NomeCli");

			service.save(client);
		} catch (final AppException error) {
			assertEquals("Parametros obrigatórios faltando: [cidadeNasc].", error.getMessage());
		}

	}

	@Test
	void testErrorDetailPtBR() {

		try {

			service.get(-1);

		} catch (final AppException error) {

			assertEquals("Registro não encontrado.", error.getMessage());
		}

	}

	@Test
	void testSucess() {

		final ClientDTO client = new ClientDTO();
		client.setNomeCli("Eduardo");
		client.setDateNasc(new Date());
		client.setCidadeNasc("Curitiba");
		client.setCodCli(99);
		client.setCpfCli("08622827992");
		client.setDataCad(new Date());

		final Address address = new Address();
		address.setCity("Curitiba");
		address.setState("PR");
		address.setStreet("Rua Visconde de Nacar");

		final List<Address> list = Collections.singletonList(address);

		try {

			var result = service.saveWithTransaction(client, list);

			System.out.println(result.getCodCli());

		} catch (final Exception error) {
			// NA
		}

		var c = clientRepository.findById(client.getCodCli());

		assertTrue(c.isEmpty());

		assertEquals(0, addressRepository.count());
	}

	@Test
	void testSucessWithoutTrx() throws AppException {

		final ClientDTO client = new ClientDTO();
		client.setNomeCli("Eduardo");
		client.setDateNasc(new Date());
		client.setCidadeNasc("Curitiba");
		client.setCpfCli("08622827992");
		client.setDataCad(new Date());

		final Address address = new Address();
		address.setCity("Curitiba");
		address.setState("PR");
		address.setStreet("Rua Visconde de Nacar");

		final List<Address> list = Collections.singletonList(address);

		service = new ClientService(clientRepository, addressRepository);

		var result = service.saveWithoutTransaction(client, list);

		System.out.println(result.getCodCli());

		var c = clientRepository.findById(client.getCodCli());

		assertFalse(c.isEmpty());

		assertEquals(1, addressRepository.count());
	}

}
