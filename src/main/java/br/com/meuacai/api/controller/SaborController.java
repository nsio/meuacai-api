package br.com.meuacai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuacai.api.domain.model.Sabor;
import br.com.meuacai.api.domain.service.SaborService;

@RestController
@RequestMapping("/sabores")
public class SaborController {

	@Autowired
	private SaborService saborService;
	
	@GetMapping
	public List<Sabor> listar(){
		return this.saborService.listar();
	}
	
}
