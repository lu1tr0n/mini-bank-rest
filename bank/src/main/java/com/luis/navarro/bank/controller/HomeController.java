package com.luis.navarro.bank.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.util.ResponseFactory;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Contact;

@Tag(name = "Home Management", description = "here you get the home endpoints")
@RestController
@RequestMapping
public class HomeController {

	@GetMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> firstPage() {
		return ResponseFactory.ok(new Info().title("Bank Online API").description("bank Online API Rest Description")
				.version("Version 1").license(new License().name("Apache 2.0").url("http://springdoc.org"))
				.contact(new Contact().email("lu1tr0n.developer@gmail.com").url("https://elsolitario.org/").name("Luis Navarro")));
	}
}
