package br.com.AttornatusBackEndTest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.AttornatusBackEndTest.entities.Enderecos;
import br.com.AttornatusBackEndTest.entities.Pessoa;
import br.com.AttornatusBackEndTest.exceptions.ExceptionCustom;
import br.com.AttornatusBackEndTest.repositories.EnderecoRepository;
import br.com.AttornatusBackEndTest.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Pessoa> buscarPessoas() {
		try {
			List<Pessoa> listaPessoas = pessoaRepository.findAll();
			return listaPessoas;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionCustom("Não foi possível realizar a operação.");
		}
	}

	// Método para buscar por Id
	public Pessoa buscarPorId(Long idPessoa) {
		try {
			Optional<Pessoa> listaPessoa = pessoaRepository.findById(idPessoa);
			return listaPessoa.get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionCustom("Não foi possível realizar a operação.");
		}

	}

	// Método para Inserir uma Nova Pessoa
	public String insertPessoa(Pessoa pessoa) {
		try {
			Enderecos endereco = new Enderecos();
			endereco = pessoa.getEndereco();
			enderecoRepository.save(endereco);
			pessoaRepository.save(pessoa);

			return "Pessoa salva com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionCustom("Não foi possível realizar a operação.");
		}
	}

	// Método para Exluir Pessoa
	@DeleteMapping("/{id}")
	public String deletePessoa(@PathVariable("id") Long idPessoa) {
		try {
			Pessoa Pessoa = pessoaRepository.findById(idPessoa).get();
			if (Pessoa != null) {
				pessoaRepository.deleteById(idPessoa);
				return "Pessoa Deletada com sucesso";
			}
			return "Não foi possivel encontrar a Pessoa";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionCustom("Não foi possível realizar a operação.");
		}
	}

	public Pessoa update(Long id, Pessoa objPessoa) {
		Pessoa obj = buscarPorId(id);
		obj.setNome(objPessoa.getNome());
		obj.setData_Nascimento(objPessoa.getData_Nascimento());
		obj.setEndereco(objPessoa.getEndereco());
		return pessoaRepository.save(obj);

	}

}
