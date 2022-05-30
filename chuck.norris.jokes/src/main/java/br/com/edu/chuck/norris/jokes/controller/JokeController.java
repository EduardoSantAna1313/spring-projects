package br.com.edu.chuck.norris.jokes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.edu.chuck.norris.jokes.service.JokeService;

/**
 * @author Eduardo
 */
@Controller
public class JokeController {

	private JokeService service;

	public JokeController(JokeService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public String joke(final Model model) {

		final var joke = service.getJoke();

		model.addAttribute("joke", joke);

		return "index";
	}

}
