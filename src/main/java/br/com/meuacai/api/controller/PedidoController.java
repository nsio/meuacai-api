package br.com.meuacai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meuacai.api.domain.dto.PedidoDTO;
import br.com.meuacai.api.domain.dto.PedidoPrimeiraEtapaDTO;
import br.com.meuacai.api.domain.dto.ResumoPedidoDTO;
import br.com.meuacai.api.domain.model.Pedido;
import br.com.meuacai.api.domain.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
//	@PostMapping
//	public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO pedidoDTO) {
//		
//		Pedido p = this.pedidoService.salvar(pedidoDTO.transformarParaEntidade());
//		
//		return new ResponseEntity<>(p, HttpStatus.CREATED);
//		
//	}
	
	@PostMapping
	public ResponseEntity<PedidoPrimeiraEtapaDTO> escolerAcai(@RequestBody PedidoDTO pedidoDTO) {
		PedidoPrimeiraEtapaDTO p = this.pedidoService.escolherAcai(pedidoDTO.transformarParaEntidade());
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Pedido> personalizar(@RequestBody PedidoDTO pedidoDTO) {
		Pedido p = this.pedidoService.personalizar(pedidoDTO.transformarParaEntidade());
		return new ResponseEntity<>(p, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/resumo/{idPedido}")
	public ResponseEntity<ResumoPedidoDTO> resumo(@PathVariable("idPedido") Long idPedido){
		ResumoPedidoDTO resumoDto = this.pedidoService.resumo(idPedido);
		return new ResponseEntity<>(resumoDto, HttpStatus.OK);
	}
	
	@GetMapping("/{idPedido}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable("idPedido") Long id){
		Pedido p = this.pedidoService.buscarPorId(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listar(){
		List<Pedido> pedidos = this.pedidoService.listar();
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
	
}
