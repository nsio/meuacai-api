package br.com.meuacai.api.domain.dto;

import java.math.BigDecimal;

public class PedidoPrimeiraEtapaDTO {
	
	private Long idPedido;
	private BigDecimal valorPedido;
	private Integer tempoPreparoPedido;
	private String descricaoSabor;
	private String descricaoTamanho;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public BigDecimal getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Integer getTempoPreparoPedido() {
		return tempoPreparoPedido;
	}
	public void setTempoPreparoPedido(Integer tempoPreparoPedido) {
		this.tempoPreparoPedido = tempoPreparoPedido;
	}
	public String getDescricaoSabor() {
		return descricaoSabor;
	}
	public void setDescricaoSabor(String descricaoSabor) {
		this.descricaoSabor = descricaoSabor;
	}
	public String getDescricaoTamanho() {
		return descricaoTamanho;
	}
	public void setDescricaoTamanho(String descricaoTamanho) {
		this.descricaoTamanho = descricaoTamanho;
	}
	
}
