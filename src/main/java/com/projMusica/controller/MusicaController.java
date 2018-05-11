package com.projMusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projMusica.model.Musica;
import com.projMusica.repository.MusicaRepository;

@RestController
public class MusicaController {

	@Autowired
	MusicaRepository repository;//faz persistencia d dados no banco
	
	//http://localhost:8080/api/save	
	/*
	 * INSERIR
	   {
	    "numConta": 10,
	    "descricao": "Conta Corrente",
	    "valor": 1500
	   }
	 * 
	 * ALTERAR
	   {
	    "id" : 1
	    "numConta": 10,
	    "descricao": "Conta Poupança",
	    "valor": 1500
	   }
	 * */
	@PostMapping("api/save")//metodo q insere e altere o banco/chamando o metodo save
	public Musica save(@RequestBody Musica musica){
		return repository.save(musica);
	}
	
	//http://localhost:8080/api/all
	@GetMapping("api/all")//metodo retorna uma lista de conta
	public List<Musica> all(){
		return (List<Musica>) repository.findAll();
	}
	
	//http://localhost:8080/api/delete/2
	@GetMapping("api/delete/{id}")//deleta um registro de dados
	public boolean delete(@PathVariable("id") Long id) {
		try {
			repository.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
}
}