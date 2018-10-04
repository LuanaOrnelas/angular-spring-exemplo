package com.koffemore.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.koffemore.model.Pessoa;
import com.koffemore.model.Response;
import com.koffemore.repository.PessoaRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PessoaService {
 
	@Autowired
	private PessoaRepository pessoaRepository; 
 
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response salvar(@RequestBody Pessoa pessoa){
 
 
		try {
 
			this.pessoaRepository.save(pessoa);
 
			return new Response(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new Response(0,e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response atualizar(@RequestBody Pessoa pessoa){
 
		try {
 
			this.pessoaRepository.save(pessoa);		
 
			return new Response(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new Response(0,e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Pessoa> consultar(){
 
		return this.pessoaRepository.findAll();
	}
 
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Pessoa buscar(@PathVariable("codigo") Integer codigo){
 
		return this.pessoaRepository.findByCodigo(codigo);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("codigo") Integer codigo){
 
		Pessoa Pessoa = pessoaRepository.findByCodigo(codigo);
 
		try {
 
			pessoaRepository.delete(Pessoa);
 
			return new Response(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new Response(0, e.getMessage());
		}
	}
 
}