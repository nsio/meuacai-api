package br.com.meuacai.api.domain.exception;

public class TamanhoNaoEncontradoException extends EntidadeNaoEncontradaExcption {
	
	private static final long serialVersionUID = 1L;
	
	public TamanhoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TamanhoNaoEncontradoException(Long pedidoId) {
		this(String.format("Não existe um cadastro de tamanho com código %d", pedidoId));
	}
	
}
