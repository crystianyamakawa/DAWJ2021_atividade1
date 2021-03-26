package br.com.crystianyamakawa.individual.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.crystianyamakawa.individual.cadastros.ProdutoRepositorio;


@Controller
public class ProdutoControle {

	private ProdutoRepositorio produtoRepo;
	
	
	public ProdutoControle(ProdutoRepositorio produtoRepo) {
		this.produtoRepo = produtoRepo;
		
	}
	
	@GetMapping("/cadastros/produtos")
	public String produtos(Model model) {
		model.addAttribute("listaProdutos", produtoRepo.findAll());
		return "cadastros/produtos/index";
	}
}
