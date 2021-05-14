package br.com.arfaxtec.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.arfaxtec.apirest.model.Telefone;
import br.com.arfaxtec.apirest.model.Usuario;
import br.com.arfaxtec.apirest.repository.TelefoneRepository;
import br.com.arfaxtec.apirest.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/system")
public class UsuarioController {
	
	@Autowired//injeção de dependência do spring
	private UsuarioRepository usuarioRepository;
	
	@Autowired//injeção de dependência do spring
	private TelefoneRepository telefonerepository;

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
	
	/**
	 * Na inserção dos dados tem que colocar a anotação @requestBody
	 * @param usuario
	 * @return
	 */
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
		
		for (int posicao = 0; posicao < usuario.getTelefones().size(); posicao++) {
			usuario.getTelefones().get(posicao).setUsuario(usuario);
		}
		Usuario u = usuarioRepository.save(usuario);
		return new ResponseEntity(u, HttpStatus.OK);
		
	}
	
	/**
	 * Método de atualização
	 * @param id
	 * @param usuario
	 * @return
	 */
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario){
		
		return usuarioRepository.findById(id).map(
				record -> {
					record.setId(usuario.getId());
					record.setNome(usuario.getNome());
					record.setEmail(usuario.getEmail());
					record.setCargo(usuario.getCargo());
					record.setLogin(usuario.getLogin());
					record.setSenha(usuario.getSenha());
					
					Usuario user = usuarioRepository.save(record);
					
					return ResponseEntity.ok().body(user);
				}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long id){
		
		usuarioRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "/addPhone/", produces = "application/json")
	public ResponseEntity<Telefone> addTelefone(@RequestBody Telefone telefone) {
		
		Telefone t = telefonerepository.save(telefone);
		
		return new ResponseEntity(t, HttpStatus.OK);
	}
}
