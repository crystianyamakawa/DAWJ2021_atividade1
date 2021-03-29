package br.com.crystianyamakawa.individual;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.crystianyamakawa.individual.cadastros.Pedido;
import br.com.crystianyamakawa.individual.cadastros.PedidoItem;
import br.com.crystianyamakawa.individual.cadastros.PedidoItemRepositorio;
import br.com.crystianyamakawa.individual.cadastros.PedidoRepositorio;
import br.com.crystianyamakawa.individual.cadastros.Pessoa;
import br.com.crystianyamakawa.individual.cadastros.PessoaRepositorio;
import br.com.crystianyamakawa.individual.cadastros.Produto;
import br.com.crystianyamakawa.individual.cadastros.ProdutoRepositorio;

//@Transactional
@Component
public class PopulacaoInicialDB implements CommandLineRunner{
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	@Autowired
	private ProdutoRepositorio produtoRepo;
	@Autowired
	private PedidoRepositorio pedidoRepo;
	@Autowired
	private PedidoItemRepositorio pedidoItemRepo;
	
	
	@Override
	public void run(String... args) throws Exception{
		
		//Clientes
		Pessoa c1 = new Pessoa("Crystian");
		c1.setTelefone("9999-9999");
		c1.setEmail("crystian@gmail.com");
		
		Pessoa c2 = new Pessoa("Gisele");
		c2.setTelefone("9999-8888");
		c2.setEmail("gisele@gmail.com");

		Pessoa c3 = new Pessoa("Maria Julia");
		c3.setTelefone("9999-7777");
		c3.setEmail("maria@gmail.com");
		
		Pessoa c4= new Pessoa("Rafael");
		c4.setTelefone("9999-6666");
		c4.setEmail("rafael@gmail.com");
		
		pessoaRepo.save(c1);
		pessoaRepo.save(c2);
		pessoaRepo.save(c3);
		pessoaRepo.save(c4);
		
		//Produtos
		
		Produto p1 = new Produto("Bicicleta");
		p1.setValor(Float.valueOf(1500));
		produtoRepo.save(p1);
		Produto p2 = new Produto("Relogio");
		p2.setValor(Float.valueOf(300));
		Produto p3 = new Produto("Bola");
		p3.setValor(Float.valueOf(50));
		Produto p4 = new Produto("Computador");
		p4.setValor(Float.valueOf(3500));
		Produto p5 = new Produto("Celular");
		p5.setValor(Float.valueOf(2000));
		
		produtoRepo.save(p1);
		produtoRepo.save(p2);
		produtoRepo.save(p3);
		produtoRepo.save(p4);
		produtoRepo.save(p5);
		
		
		// Pedidos
		Pedido pd1 = new Pedido(LocalDate.of(2021,1,3), c1);
		pedidoRepo.save(pd1);
		
		PedidoItem pdi1 = new PedidoItem("");
		pdi1.setPedido(pd1);
		pdi1.setProduto(p1);
		pdi1.setQtd(Float.valueOf(2));
		pdi1.setValor(p1.getValor()*pdi1.getQtd());
		pedidoItemRepo.save(pdi1);
		
		PedidoItem pdi2 = new PedidoItem("");
		pdi2.setPedido(pd1);
		pdi2.setProduto(p2);
		pdi2.setQtd(Float.valueOf(5));
		pdi2.setValor(p2.getValor()*pdi2.getQtd());
		pedidoItemRepo.save(pdi2);
		
		Pedido pd2 = new Pedido(LocalDate.of(2021,1,3), c2);
		pedidoRepo.save(pd2);
		
		PedidoItem pdi3 = new PedidoItem("");
		pdi3.setPedido(pd2);
		pdi3.setProduto(p3);
		pdi3.setQtd(Float.valueOf(2));
		pdi3.setValor(p3.getValor()*pdi3.getQtd());
		pedidoItemRepo.save(pdi3);
		
		PedidoItem pdi4 = new PedidoItem("");
		pdi4.setPedido(pd2);
		pdi4.setProduto(p5);
		pdi4.setQtd(Float.valueOf(4));
		pdi4.setValor(p5.getValor()*pdi4.getQtd());
		pedidoItemRepo.save(pdi4);
		
		
	
	}

}
