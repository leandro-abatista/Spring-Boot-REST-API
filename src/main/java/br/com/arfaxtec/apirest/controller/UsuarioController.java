package br.com.arfaxtec.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/system")
public class UsuarioController {

	/**
	 * Recebendo um parâmetro e o valor padrão
	 * Serviço RESTFul
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init(@RequestParam (value = "nome", defaultValue = "valorpadrão") String nome) {
		
		System.out.println("Parametro sendo recebido!!!");
		return new ResponseEntity("Olá Usuário Rest Spring Boot, seu nome é : " + nome, HttpStatus.OK);
	} 
	
	/**
	 * Recebendo um parâmetro e Requerid
	 * Serviço RESTFul
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/usuario", produces = "application/json")
	public ResponseEntity testeInit(@RequestParam (value = "nome", required = true, defaultValue = "Informe um nome!") String nome) {
		
		System.out.println("Parametro sendo recebido!!!");
		return new ResponseEntity("Olá Usuário Rest Spring Boot, seu nome é : " + nome, HttpStatus.OK);
	} 
}
