package br.com.meuacai.api.domain.dto;

import java.math.BigDecimal;

public class PersonalizacaoDTO {
	
	private String descricao;
	private BigDecimal preco;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
