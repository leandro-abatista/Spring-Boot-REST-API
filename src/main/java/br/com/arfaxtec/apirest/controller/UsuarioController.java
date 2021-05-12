package br.com.arfaxtec.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/system")
public class UsuarioController {

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init() {
		return new ResponseEntity("Olá Rest Spring Boot", HttpStatus.OK);
	} 
}
