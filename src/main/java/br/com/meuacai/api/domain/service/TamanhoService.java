package br.com.meuacai.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meuacai.api.domain.exception.TamanhoNaoEncontradoException;
import br.com.meuacai.api.domain.model.Tamanho;
import br.com.meuacai.api.domain.repository.TamanhoRepository;

@Service
public class TamanhoService {

	@Autowired
	private TamanhoRepository tamanhoRepository;
	
	public List<Tamanho> listar(){
		return this.tamanhoRepository.findAll();
	}
	
	public Tamanho buscarPorId(Long id) {
		return this.tamanhoRepository.findById(id)
					.orElseThrow(() -> new TamanhoNaoEncontradoException(id));
	}
	
}
