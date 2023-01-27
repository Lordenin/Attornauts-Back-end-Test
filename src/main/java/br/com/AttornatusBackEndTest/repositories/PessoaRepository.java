package br.com.AttornatusBackEndTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.AttornatusBackEndTest.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
