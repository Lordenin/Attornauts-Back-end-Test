package br.com.AttornatusBackEndTest.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enderecos")
public class Enderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	private String logradouro;

	private String CEP;

	private int numero;

	private String cidade;

	private Boolean principal;

	@JsonIgnore
	@OneToMany(mappedBy = "endereco")
	private List<Pessoa> pessoas;

	public Enderecos() {

	}

	public Enderecos(String logradouro, String CEP, int numero, String cidade, Boolean principal) {
		super();
		this.logradouro = logradouro;
		this.CEP = CEP;
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;

	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Boolean getPrincipal() {
		if(principal == null) {
			principal = false;
		}
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

}
