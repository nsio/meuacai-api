package br.com.meuacai.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meuacai.api.domain.exception.PersonalizacaoNaoEncontradoException;
import br.com.meuacai.api.domain.model.Personalizacao;
import br.com.meuacai.api.domain.repository.PersonalizacaoRepository;

@Service
public class PersonalizacaoService {

	@Autowired
	private PersonalizacaoRepository personalizacaoRepository;
	
	public List<Personalizacao> listar(){
		return this.personalizacaoRepository.findAll();
	}
	
	public Personalizacao buscarPorId(Long id) {
		return this.personalizacaoRepository.findById(id)
					.orElseThrow(() -> new PersonalizacaoNaoEncontradoException(id));
	}
	
}
