package br.com.meuacai.api.domain.exception;

public class PersonalizacaoNaoEncontradoException extends EntidadeNaoEncontradaExcption {
	
	private static final long serialVersionUID = 1L;
	
	public PersonalizacaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PersonalizacaoNaoEncontradoException(Long pedidoId) {
		this(String.format("Não existe um cadastro de personalização com código %d", pedidoId));
	}
	
}
