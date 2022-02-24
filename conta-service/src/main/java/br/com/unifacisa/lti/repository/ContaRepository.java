package br.com.unifacisa.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacisa.lti.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
