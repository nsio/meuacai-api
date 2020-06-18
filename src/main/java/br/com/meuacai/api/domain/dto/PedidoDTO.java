package br.com.meuacai.api.domain.dto;

import java.util.List;

import br.com.meuacai.api.domain.model.Pedido;
import br.com.meuacai.api.domain.model.Personalizacao;
import br.com.meuacai.api.domain.model.Sabor;
import br.com.meuacai.api.domain.model.Tamanho;

public class PedidoDTO {
	
	private Long idPedido;
	private Tamanho tamanho;
	private Sabor sabor;
	private List<Personalizacao> personalizacoes;
	
	public Pedido transformarParaEntidade() {
		return new Pedido(idPedido, tamanho, sabor, personalizacoes);
	}
		
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public List<Personalizacao> getPersonalizacoes() {
		return personalizacoes;
	}

	public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
		this.personalizacoes = personalizacoes;
	}
	
}
