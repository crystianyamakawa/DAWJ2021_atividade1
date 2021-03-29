package br.com.crystianyamakawa.individual.cadastros;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long>{
	@Query("select i from PedidoItem i join Pedido p where p.id = :id")
	Optional<PedidoItem> findByPedidoId(@Param("id") long id);	


}
