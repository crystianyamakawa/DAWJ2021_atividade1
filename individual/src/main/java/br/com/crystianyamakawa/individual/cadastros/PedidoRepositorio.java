package br.com.crystianyamakawa.individual.cadastros;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crystianyamakawa.individual.cadastros.dtos.PedidoListaDTO;




@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> , PedidoRepositoryCustom {
//	@Query("select new br.com.crystianyamakawa.individual.cadastros.dtos.PedidoListaDTO(p.id, p.dataPedido,c.nome)"
//			+ " from Pedido p left join p.cliente c")
//	List<PedidoListaDTO> findAllPedidoLista();

}
