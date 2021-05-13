package br.com.arfaxtec.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.arfaxtec.apirest.model.Usuario;

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
		
		return new ResponseEntity("Olá Usuário Rest Spring Boot, seu nome é : " + nome, HttpStatus.OK);
	} 
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/user", produces = "application/json")
	public ResponseEntity retornaUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setLogin("Leandro");
		usuario.setSenha("123");
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	} 
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/listuser", produces = "application/json")
	public ResponseEntity retornaListaUsuarios() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setLogin("Leandro");
		usuario.setSenha("123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(1L);
		usuario2.setLogin("Leandro");
		usuario2.setSenha("123");
		
		List<Usuario> lista = new ArrayList<>();
		
		lista.add(usuario);
		lista.add(usuario2);
		
		return new ResponseEntity(lista, HttpStatus.OK);
	} 
	
	
}
