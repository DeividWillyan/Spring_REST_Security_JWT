package br.com.RESTful.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TesteController {

	@RequestMapping(value = "/hello/{nome}")
	@PreAuthorize("isAuthenticated()")
	public String hello(@PathVariable("nome") String nome) {
		return "Hello " + nome + "!";
	}

	@RequestMapping(value = "/helloAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String helloAdmin() {
		return "Hello administrator!";
	}

}
