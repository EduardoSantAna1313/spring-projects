package br.com.edu.chuck.norris.jokes.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.edu.chuck.norris.jokes.service.JokeService;

/**
 * Chuck Norris Quotes Service.
 * 
 * @author Eduardo
 */
@Service
public class QuotesService implements JokeService {

	private Random rand;

	private List<String> jokes;

	public QuotesService() {
		rand = new Random();
	}

	@Override
	public String getJoke() {

		var listJokes = getJokes();

		return listJokes.get(rand.nextInt(listJokes.size()));
	}

	public List<String> getJokes() {

		if (jokes == null) {
			jokes = loadJokes();
		}

		return jokes;
	}

	private List<String> loadJokes() {

		try (final var is = this.getClass().getResource("jokes.txt").openStream()) {

			final String text = new String(is.readAllBytes());

			return Arrays.asList(text.split(System.lineSeparator()));
		} catch (final IOException error) {
			return List.of();
		}

	}

}
