package br.com.meuacai.api.domain.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResumoPedidoDTO {

	private Long id;
	
	private String descricaoTamanho;
	private String descricaoSabor;
	private BigDecimal precoTamnho;
	
	private List<PersonalizacaoDTO> personalizacoes = new ArrayList<PersonalizacaoDTO>();
	
	private Integer tempoTotalPreparo;
	private BigDecimal valorTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoTamanho() {
		return descricaoTamanho;
	}
	public void setDescricaoTamanho(String descricaoTamanho) {
		this.descricaoTamanho = descricaoTamanho;
	}
	public String getDescricaoSabor() {
		return descricaoSabor;
	}
	public void setDescricaoSabor(String descricaoSabor) {
		this.descricaoSabor = descricaoSabor;
	}
	public BigDecimal getPrecoTamnho() {
		return precoTamnho;
	}
	public void setPrecoTamnho(BigDecimal precoTamnho) {
		this.precoTamnho = precoTamnho;
	}
	public List<PersonalizacaoDTO> getPersonalizacoes() {
		return personalizacoes;
	}
	public void setPersonalizacoes(List<PersonalizacaoDTO> personalizacoes) {
		this.personalizacoes = personalizacoes;
	}
	public Integer getTempoTotalPreparo() {
		return tempoTotalPreparo;
	}
	public void setTempoTotalPreparo(Integer tempoTotalPreparo) {
		this.tempoTotalPreparo = tempoTotalPreparo;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
