package br.com.arfaxtec.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.arfaxtec.apirest.model.Usuario;
import br.com.arfaxtec.apirest.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/system")
public class UsuarioController {
	
	@Autowired//injeção de dependência do spring
	private UsuarioRepository usuarioRepository;

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
	
	/**
	 * Lista todos os usuários
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/listuser", produces = "application/json")
	public ResponseEntity retornaListaUsers() {
		
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
	
	/**
	 * Lista todos os usuários
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/usuarios", produces = "application/json")
	public ResponseEntity retornaLista() {
		
		Iterable<Usuario> lista = usuarioRepository.findAll();
		
		return new ResponseEntity(lista, HttpStatus.OK);
	} 
	
	/**
	 * Consultado usuário por id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity retornaListaUsuarios(@PathVariable(value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	} 
	
	/**
	 * Passando dois parâmetros
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/{id}/codigoVenda/{idvenda}", produces = "application/json")
	public ResponseEntity relatorio(@PathVariable(value = "id") Long id,
									@PathVariable(value = "idvenda") Long idvenda) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	} 
	
	
}
