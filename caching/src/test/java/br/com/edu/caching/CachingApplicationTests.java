/* (C)2023 */
package br.com.edu.caching;

import static org.junit.jupiter.api.Assertions.*;

import br.com.edu.caching.controller.TokenController;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CachingApplicationTests {

	@Autowired
	private TokenController controller;

	private String clientId;

	@BeforeEach
	public void setUp() {
		clientId = UUID.randomUUID().toString();
	}

	@Test
	public void shouldReturnToken() {
		var token = controller.getToken(clientId);
		assertNotNull(token);
		assertEquals(UUID.fromString(clientId).toString(), token.getAccessToken());
		assertFalse(token.isExpired());
	}


	@Test
	public void shouldReturnSameToken() {
		var firstToken = controller.getToken(clientId);

		var secondToken = controller.getToken(clientId);

		assertEquals(firstToken, secondToken);
	}

	@Test
	public void shouldHaveNewToken() throws InterruptedException {
		var firstToken = controller.getToken(clientId);

		TimeUnit.SECONDS.sleep(5);

		var secondToken = controller.getToken(clientId);

		assertNotEquals(firstToken, secondToken);
		assertNotEquals(firstToken.getRandomId(), secondToken.getRandomId());
		assertNotEquals(firstToken.getCreatedAt(), secondToken.getCreatedAt());
	}

}
