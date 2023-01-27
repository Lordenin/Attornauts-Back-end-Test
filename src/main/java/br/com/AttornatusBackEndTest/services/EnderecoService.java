package br.com.AttornatusBackEndTest.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.AttornatusBackEndTest.entities.Enderecos;
import br.com.AttornatusBackEndTest.entities.Pessoa;
import br.com.AttornatusBackEndTest.exceptions.ExceptionCustom;
import br.com.AttornatusBackEndTest.repositories.EnderecoRepository;
import br.com.AttornatusBackEndTest.repositories.PessoaRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Enderecos> buscarEnderecos() {
		try {
			List<Enderecos> listaEnderecos = enderecoRepository.findAll();
			return listaEnderecos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionCustom("Não foi possível realizar a operação.");
		}

	}

	public Pessoa insertEndereco(Long id_Pessoa, Enderecos objEndereco) {
		objEndereco.setIdEndereco(null);
		Pessoa pessoa = pessoaService.buscarPorId(id_Pessoa);
		if (objEndereco.getPessoas() == null) {
			objEndereco.setPessoas(new ArrayList<Pessoa>());
		}
		objEndereco.getPessoas().add(pessoa);
		enderecoRepository.save(objEndereco);
		pessoa.setEndereco(objEndereco);
		return pessoaRepository.save(pessoa);
	}
}
