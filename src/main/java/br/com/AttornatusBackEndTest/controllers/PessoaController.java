package br.com.AttornatusBackEndTest.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.AttornatusBackEndTest.DTO.PessoaDTO;
import br.com.AttornatusBackEndTest.entities.Pessoa;
import br.com.AttornatusBackEndTest.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	//Bustar todos
	@GetMapping
	public ResponseEntity<List<Pessoa>> buscarPessoas() {
		List<Pessoa> pessoas = pessoaService.buscarPessoas();
		return ResponseEntity.ok().body(pessoas);
	}
	//Buscar por Id
	@GetMapping(value = "/{id}")
	public ResponseEntity <Pessoa> buscarPessoa(@PathVariable("id")Long idPessoa) {
		Pessoa pessoas = pessoaService.buscarPorId(idPessoa);
		return ResponseEntity.ok().body(pessoas);
	}
	//Add uma nova pessoa
	@PostMapping("/add")
	public ResponseEntity<String> insertPessoa(@RequestBody Pessoa pessoa) {
		String retorno = pessoaService.insertPessoa(pessoa);
		return ResponseEntity.ok(retorno);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa objPessoa){
		Pessoa newObj = pessoaService.update(id, objPessoa);
		return ResponseEntity.ok().body(new Pessoa(newObj));
	}
	
	@GetMapping("/pessoaDTO")
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<Pessoa> list = pessoaService.buscarPessoas();
		//Pega e converte a lista de pessoa para pessoaDTO
		List<PessoaDTO> listDTO = list.stream().map(obj-> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
}




