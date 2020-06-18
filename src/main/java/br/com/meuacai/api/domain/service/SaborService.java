package br.com.meuacai.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meuacai.api.domain.exception.SaborNaoEncontradoException;
import br.com.meuacai.api.domain.model.Sabor;
import br.com.meuacai.api.domain.repository.SaborRepository;

@Service
public class SaborService {

	@Autowired
	private SaborRepository repository;
	
	public List<Sabor> listar(){
		return this.repository.findAll();
	}
	
	public Sabor buscarPorId(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new SaborNaoEncontradoException(id));
	}
}
