package br.com.meuacai.api.domain.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.meuacai.api.domain.dto.PedidoPrimeiraEtapaDTO;
import br.com.meuacai.api.domain.dto.PersonalizacaoDTO;
import br.com.meuacai.api.domain.dto.ResumoPedidoDTO;
import br.com.meuacai.api.domain.exception.NegocioExcption;
import br.com.meuacai.api.domain.exception.PedidoNaoEncontradoException;
import br.com.meuacai.api.domain.model.Pedido;
import br.com.meuacai.api.domain.model.Personalizacao;
import br.com.meuacai.api.domain.model.enumeradores.PedidoStatusEnum;
import br.com.meuacai.api.domain.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private TamanhoService tamanhoService;
	
	@Autowired
	private SaborService saborService;
	
	@Autowired
	private PersonalizacaoService personalizacaoService;
	
//	public Pedido salvar(Pedido pedido)  {
//		
//		this.verificarTamanho(pedido);
//		this.verificarSabor(pedido);
//		this.verificarPersonalizacao(pedido);
//		
//		BigDecimal valorTotal = pedido.getPersonalizacaos().stream().map(p -> p.getPreco()).reduce(BigDecimal.ZERO, BigDecimal::add);
//		Integer tempoPreparoTotal =pedido.getPersonalizacaos().stream().map(p -> p.getTempoPreparo()).reduce(0, (x,y) -> x + y);
//		tempoPreparoTotal += pedido.getTamanho().getTempoPreparo();
//		tempoPreparoTotal += pedido.getSabor().getTempoPreparo();
//		
//		pedido.setTempoPreparo(tempoPreparoTotal);
//		
//		valorTotal = valorTotal.add(pedido.getTamanho().getPreco());
//		valorTotal = valorTotal.add(pedido.getSabor().getPreco());
//		pedido.setValorTotal(valorTotal);
//		
//		return this.pedidoRepository.save(pedido);
//		
//	}
	
	public PedidoPrimeiraEtapaDTO escolherAcai(Pedido pedido)  {
		
		this.verificarTamanho(pedido);
		this.verificarSabor(pedido);
		pedido.setStatus(PedidoStatusEnum.ABERTO);
		
		BigDecimal valorTotal = pedido.getTamanho().getPreco().add(pedido.getSabor().getPreco());
		Integer tempoPreparo = pedido.getTamanho().getTempoPreparo() + pedido.getSabor().getTempoPreparo();
		
		pedido.setTempoPreparo(tempoPreparo);
		pedido.setValorTotal(valorTotal);
		
		Pedido pedidoSalvo = this.pedidoRepository.save(pedido);
		
		PedidoPrimeiraEtapaDTO dto = new PedidoPrimeiraEtapaDTO();
		dto.setIdPedido(pedidoSalvo.getId());
		dto.setValorPedido(valorTotal);
		//dto.setTempoPreparoPedido(tempoPreparo);
		dto.setDescricaoTamanho(montarDescricaoTamanho(pedido));
		dto.setDescricaoSabor(pedido.getSabor().getDescricao());
		
		return dto;
	}
	
	public Pedido personalizar(Pedido pedido) {
		
		Optional.ofNullable(pedido)
				.map(p -> pedido.getId())
				.orElseThrow(() -> new NegocioExcption("Não foi possível personalizar o pedido, pois está faltando o identificador."));
		
		Pedido pedidoAtual = this.buscarPorId(pedido.getId());
		pedidoAtual.setStatus(PedidoStatusEnum.FINALIZADO);
		
		if(pedido.getPersonalizacaos().isEmpty()) {
			pedidoAtual = this.pedidoRepository.save(pedidoAtual);
			return pedidoAtual;
		}
		
		this.verificarPersonalizacao(pedido);
		
		Integer tempoPreparoTotal = pedido.getPersonalizacaos().stream().map(p -> p.getTempoPreparo()).reduce(0, (x,y) -> x + y);
		tempoPreparoTotal += pedidoAtual.getTamanho().getTempoPreparo();
		tempoPreparoTotal += pedidoAtual.getSabor().getTempoPreparo();
		
		pedido.setTempoPreparo(tempoPreparoTotal);
		
		BigDecimal valorTotal = pedido.getPersonalizacaos().stream().map(p -> p.getPreco()).reduce(BigDecimal.ZERO, BigDecimal::add);
		valorTotal = valorTotal.add(pedidoAtual.getTamanho().getPreco());
		valorTotal = valorTotal.add(pedidoAtual.getSabor().getPreco());
		
		pedidoAtual.setValorTotal(valorTotal);
		pedidoAtual.setTempoPreparo(tempoPreparoTotal);
		pedidoAtual.setPersonalizacaos(pedido.getPersonalizacaos());
		
		pedidoAtual = this.pedidoRepository.save(pedidoAtual);
		
		return pedidoAtual;
		
	}
	
	public ResumoPedidoDTO resumo(Long idPedido) {
		Pedido pedido = buscarPorId(idPedido);
		ResumoPedidoDTO resumo = new ResumoPedidoDTO();
		
		resumo.setId(pedido.getId());
		
		resumo.setDescricaoSabor(pedido.getSabor().getDescricao());
		resumo.setDescricaoTamanho(montarDescricaoTamanho(pedido));
		resumo.setPrecoTamnho(pedido.getTamanho().getPreco());
		
		resumo.setTempoTotalPreparo(pedido.getTempoPreparo());
		resumo.setValorTotal(pedido.getValorTotal());
		
		pedido.getPersonalizacaos().forEach(p -> {
			PersonalizacaoDTO pDto = new PersonalizacaoDTO();
			pDto.setDescricao(p.getDescricao());
			pDto.setPreco(p.getPreco());
			resumo.getPersonalizacoes().add(pDto);
		});
		
		return resumo;
	}
	
	public Pedido buscarPorId(Long id) {
		return this.pedidoRepository.findById(id)
							.orElseThrow(() -> new PedidoNaoEncontradoException(id));
	}
	
	public List<Pedido> listar(){
		return this.pedidoRepository.findAll();
	}
	
	private String montarDescricaoTamanho(Pedido pedido) {
		return String.format("%s (%sml)", pedido.getTamanho().getDescricao(), pedido.getTamanho().getMl().toString());
	}
	
	private void verificarTamanho(Pedido pedido) {
		Optional.ofNullable(pedido)
				.map(p -> pedido.getTamanho().getId())
				.orElseThrow(() -> new NegocioExcption("O identificador do tamanho do açai não foi encontrado, por favor, verifique o corpo da requisição."));
		
		if(isToSave(pedido.getTamanho())) {
			pedido.setTamanho(this.tamanhoService.buscarPorId(pedido.getTamanho().getId()));
		}
	}
	
	private void verificarSabor(Pedido pedido) {
		Optional.ofNullable(pedido)
				.map(p -> pedido.getSabor().getId())
				.orElseThrow(() -> new NegocioExcption("O identificador do sabor do açai não foi encontrado, por favor, verifique o corpo da requisição."));
		
		if(isToSave(pedido.getSabor())) {
			pedido.setSabor(this.saborService.buscarPorId(pedido.getSabor().getId()));
		}
	}
	
	private void verificarPersonalizacao(Pedido pedido) {
		List<Personalizacao> personalizacaoFiltrada = pedido.getPersonalizacaos().stream().
				filter(p -> (p.getId() != null && p.getId() > 0)).
				collect(Collectors.toList());
		
		pedido.getPersonalizacaos().clear();
		
		personalizacaoFiltrada.forEach(personalizacao -> {
			if(isToSave(personalizacao)) {
				pedido.getPersonalizacaos().add(this.personalizacaoService.buscarPorId(personalizacao.getId()));
			} else {
				pedido.getPersonalizacaos().add(personalizacao);
			}
		});
		
	}
	
	private Boolean isToSave(Object object) {
		List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
		Boolean hasEmptyField = fields.stream().anyMatch(field ->{
			field.setAccessible(true);
			Object o = ReflectionUtils.getField(field, object);
			return (o == null || o == "");
		});
		return hasEmptyField;
	}
}
