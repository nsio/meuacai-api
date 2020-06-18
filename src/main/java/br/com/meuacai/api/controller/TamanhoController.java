package br.com.meuacai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuacai.api.domain.model.Tamanho;
import br.com.meuacai.api.domain.service.TamanhoService;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoController {

	@Autowired
	private TamanhoService service;
	
	@GetMapping
	public List<Tamanho> listar(){
		return this.service.listar();
	}
	
}
