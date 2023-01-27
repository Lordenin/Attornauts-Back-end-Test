package br.com.AttornatusBackEndTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.AttornatusBackEndTest.entities.Enderecos;
import br.com.AttornatusBackEndTest.entities.Pessoa;
import br.com.AttornatusBackEndTest.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Enderecos>> buscarEnderecos() {
		List<Enderecos> enderecos = enderecoService.buscarEnderecos();
		return ResponseEntity.ok().body(enderecos);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> adicionarEndereco(@RequestParam Long idPessoa, @RequestBody Enderecos enderecosRequest) {
		Pessoa pessoa = enderecoService.insertEndereco(idPessoa, enderecosRequest);
		return ResponseEntity.ok().body(pessoa);
	}

}
