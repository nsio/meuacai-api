package br.com.meuacai.api.domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.meuacai.api.domain.model.enumeradores.PedidoStatusEnum;

@Entity
public class Pedido {
	
	public Pedido() {
		
	}
	
	public Pedido(Tamanho tamanho, Sabor sabor, List<Personalizacao> personalizacoes) {
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.personalizacaos = personalizacoes;
	}
	
	public Pedido(Long idPedido, Tamanho tamanho, Sabor sabor, List<Personalizacao> personalizacoes) {
		this.id = idPedido;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.personalizacaos = personalizacoes;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tempo_preparo")
	private Integer tempoPreparo;
	
	@Column
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Tamanho tamanho;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Sabor sabor;
	
	@ManyToMany
	@JoinTable(name = "pedido_personalizacao",
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "personalizacao_id")
			)
	private List<Personalizacao> personalizacaos;
	
	@Column
	private PedidoStatusEnum status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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

	public List<Personalizacao> getPersonalizacaos() {
		return personalizacaos;
	}

	public void setPersonalizacaos(List<Personalizacao> personalizacaos) {
		this.personalizacaos = personalizacaos;
	}

	public PedidoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PedidoStatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
