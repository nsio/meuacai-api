package br.com.meuacai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuacai.api.domain.model.Personalizacao;
import br.com.meuacai.api.domain.service.PersonalizacaoService;

@RestController
@RequestMapping("/personalizacoes")
public class PersonalizacaoController {

	@Autowired
	private PersonalizacaoService personalizacaoService;
	
	@GetMapping
	public List<Personalizacao> listar(){
		return this.personalizacaoService.listar();
	}
}
