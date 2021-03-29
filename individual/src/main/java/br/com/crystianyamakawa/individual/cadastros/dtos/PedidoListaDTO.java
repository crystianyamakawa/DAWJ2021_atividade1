package br.com.crystianyamakawa.individual.cadastros.dtos;

import java.time.LocalDate;

public class PedidoListaDTO {
	
	private Long id;
	private LocalDate dataPedido;
	private String cliente;
	
	
	public PedidoListaDTO(Long id, LocalDate dataPedido, String cliente) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
	}
}