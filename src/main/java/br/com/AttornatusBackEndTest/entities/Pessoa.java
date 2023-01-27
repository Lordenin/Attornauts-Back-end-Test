package br.com.AttornatusBackEndTest.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Pessoas")
public class Pessoa {
//Deve conter: Nome, Data de nascimento, Endereço(Logradouro, CEP, Número, Cidade)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	private String nome;

	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy")
	private Date data_Nascimento;

	
	@ManyToOne
	private Enderecos endereco;

	public Pessoa() {

	}

	public Pessoa(Long idPessoa, String nome, Date data_Nascimento, Enderecos endereco) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.data_Nascimento = data_Nascimento;
		this.endereco = endereco;

	}

	public Pessoa(Pessoa newObj) {
		// TODO Auto-generated constructor stub
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdCliente(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_Nascimento() {
		return data_Nascimento;
	}

	public void setData_Nascimento(Date data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}

}
