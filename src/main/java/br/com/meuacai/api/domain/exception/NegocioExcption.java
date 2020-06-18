package br.com.meuacai.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioExcption extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NegocioExcption(String mensagem) {
		super(mensagem);
	}
	
}