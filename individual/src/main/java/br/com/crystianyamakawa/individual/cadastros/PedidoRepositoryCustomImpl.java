package br.com.crystianyamakawa.individual.cadastros;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class PedidoRepositoryCustomImpl implements PedidoRepositoryCustom{
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public Optional<Pedido> findCompletoById(Long id) {
		List<Pedido> pedidos = em.createQuery("select distinct p from Pedido p left join fetch p.itens i  where p.id = :id",Pedido.class)
		.setParameter("id",id)
		.setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
		.getResultList();
	if (pedidos == null || pedidos.isEmpty()) return Optional.empty();
	
		return Optional.of(pedidos.get(0));
	}
	

}
