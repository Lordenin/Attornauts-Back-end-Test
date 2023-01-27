package br.com.AttornatusBackEndTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AttornatusBackEndTest.entities.Enderecos;

public interface EnderecoRepository extends JpaRepository<Enderecos, Long> {

}
