/**
 * 
 */
package br.com.edu.start.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.edu.start.AppException;
import br.com.edu.start.repository.ClientRepository;

/**
 * Tests to ClientService.
 * 
 * @author Eduardo
 */
@DataJpaTest
class ClientServiceTest {

	@Autowired
	ClientRepository repository;

	ClientService service;

	@BeforeEach
	private void before() {
		service = new ClientService(repository);
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

}
