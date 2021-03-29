package br.com.crystianyamakawa.individual.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.crystianyamakawa.individual.cadastros.Produto;
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
	
	@GetMapping("/cadastros/produtos/nova")
	public String novoProduto(Model model) {
		model.addAttribute("produto", new Produto(""));
		return "cadastros/produtos/form";
	}

	
	@GetMapping("/cadastros/produtos/{id}")
	public String alterarProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produtoOpt = produtoRepo.findById(id);
		if (!produtoOpt.isPresent()) {
			throw new IllegalArgumentException("Produto Invalido.");
		}
		
		model.addAttribute("produto", produtoOpt.get());
		
		return "cadastros/produtos/form";
	}

	@PostMapping("/cadastros/produtos/salvar")
	public String salvarProduto(@ModelAttribute("produto") Produto produto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cadastros/produtos/form";
		}
		
		produtoRepo.save(produto);
		return "redirect:/cadastros/produtos";
	}
	
	
	@GetMapping("/cadastros/produtos/excluir/{id}")
	public String excluirProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produtoOpt = produtoRepo.findById(id);
		if (!produtoOpt.isPresent()) {
			throw new IllegalArgumentException("Produto Invalido.");
		}
		
		produtoRepo.delete(produtoOpt.get());
		
		return "redirect:/cadastros/produtos";
	}

}
