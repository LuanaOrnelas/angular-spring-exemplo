package com.koffemore.repository;


import java.util.List;
import org.springframework.data.repository.Repository;

import com.koffemore.model.Pessoa;


public interface PessoaRepository extends Repository<Pessoa, Integer> {

	void save(Pessoa pessoa);

	void delete(Pessoa pessoa);

	List<Pessoa> findAll();

	Pessoa findByCodigo(Integer codigo);
}