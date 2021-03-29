package br.com.crystianyamakawa.individual.cadastros;

import java.util.Optional;

public interface PedidoRepositoryCustom {
	
	Optional<Pedido> findCompletoById(Long id);

}
