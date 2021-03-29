package br.com.crystianyamakawa.individual.cadastros;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PedidoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(optional = false)
	@NotNull(message = "Selecione um pedido")
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	@NotNull(message = "Selecione um produto")
	private Produto produto;
	
	private Float qtd;
	private Float valor;
	
	@Deprecated
	public PedidoItem() {
		
	}
	
	public PedidoItem(String pedido) {
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Float getQtd() {
		return qtd;
	}
	public void setQtd(Float qtd) {
		this.qtd = qtd;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		return id == other.id;
	}
	
	
	

}
