package br.com.meuacai.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntidadeNaoEncontradaExcption extends ResponseStatusException {
	
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaExcption(HttpStatus status, String reason) {
		super(status, reason);
	}
	
	public EntidadeNaoEncontradaExcption(String mensagem) {
		this(HttpStatus.NOT_FOUND ,mensagem);
	}
	
}
