package br.com.crystianyamakawa.individual.cadastros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Pedido {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPedido;
	
	@ManyToOne(optional = false)
	@NotNull(message = "Selecione um cliente")
	private Pessoa cliente;
	
	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "pedido"
			)
	private List<PedidoItem> itens = new ArrayList<>();
	
	@Deprecated
	protected Pedido() {
		
	}
	public Pedido(LocalDate data) {
	}
	
	public Pedido(LocalDate data, Pessoa cliente) {
		this.dataPedido = data;
		this.setCliente(cliente);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", cliente=" + cliente + "]";
	}
	
	public void addItem(PedidoItem item) {
		this.itens.add(item);
		item.setPedido(this);


	}
	
	public void removeItem(PedidoItem item) {
		this.itens.remove(item);
		item.setPedido(null);
	}
	
	public void removeItem(int index) {
		PedidoItem item = this.itens.get(index);
		if (item != null) {
			this.itens.remove(index);
			item.setPedido(null);
		}
	}
	
	public List<PedidoItem> getItens() {
		return this.itens;
	}
	
	public void corrigirItens() {
		
		for (PedidoItem item : this.itens) {
			item.setPedido(this);
		}
		
	}
	
}
