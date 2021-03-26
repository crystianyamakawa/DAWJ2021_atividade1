package br.com.crystianyamakawa.individual;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.crystianyamakawa.individual.cadastros.Pessoa;
import br.com.crystianyamakawa.individual.cadastros.PessoaRepositorio;
import br.com.crystianyamakawa.individual.cadastros.Produto;
import br.com.crystianyamakawa.individual.cadastros.ProdutoRepositorio;

@Component
@Transactional
public class PopulacaoInicialDB implements CommandLineRunner{
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	private ProdutoRepositorio produtoRepo;
	
	@Override
	public void run(String... args) throws Exception{
		
		Pessoa p1 = new Pessoa("Crystian");
		p1.setTelefone("9999-9999");
		p1.setEmail("crystian@gmail.com");
		
		Pessoa p2 = new Pessoa("Gisele");
		p2.setTelefone("9999-8888");
		p2.setEmail("gisele@gmail.com");

		Pessoa p3 = new Pessoa("Maria Julia");
		p3.setTelefone("9999-7777");
		p3.setEmail("maria@gmail.com");
		
		Pessoa p4= new Pessoa("Rafael");
		p4.setTelefone("9999-6666");
		p4.setEmail("rafael@gmail.com");
		
		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
		pessoaRepo.save(p3);
		pessoaRepo.save(p4);
		
		////////////////////////////////////////////
		
		Produto pr = new Produto("Bicicleta");
	//	pr.setValor("111");
//		produtoRepo.save(pr);
//		Produto c3 = new Produto("Patins");
//		c3.setValor(Float.valueOf(300));
//		Produto c4 = new Produto("Bola");
//		c4.setValor(Float.valueOf(50));
//		Produto c5 = new Produto("Computador");
//		c5.setValor(Float.valueOf(3000));
//		Produto c6 = new Produto("Celular");
//		c6.setValor(Float.valueOf(2000));
//		
		//produtoRepo.save(pr2);
//		produtoRepo.save(c3);
//		produtoRepo.save(c4);
//		produtoRepo.save(c5);
//		produtoRepo.save(c6);
//		
	}

}
