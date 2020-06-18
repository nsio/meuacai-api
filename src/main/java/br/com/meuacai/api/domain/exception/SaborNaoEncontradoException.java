package br.com.meuacai.api.domain.exception;

public class SaborNaoEncontradoException extends EntidadeNaoEncontradaExcption {
	
	private static final long serialVersionUID = 1L;
	
	public SaborNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public SaborNaoEncontradoException(Long pedidoId) {
		this(String.format("Não existe um cadastro de sabor com código %d", pedidoId));
	}
	
}
