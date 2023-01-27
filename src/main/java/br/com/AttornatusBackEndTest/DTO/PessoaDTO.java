package br.com.AttornatusBackEndTest.DTO;

import java.io.Serializable;
import java.util.Date;

import br.com.AttornatusBackEndTest.entities.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private Date data_nascimento;

	public PessoaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getIdPessoa();
		this.nome = obj.getNome();
		this.data_nascimento = obj.getData_Nascimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

}
