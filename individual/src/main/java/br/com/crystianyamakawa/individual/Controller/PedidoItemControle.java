package br.com.crystianyamakawa.individual.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.crystianyamakawa.individual.cadastros.Pedido;
import br.com.crystianyamakawa.individual.cadastros.PedidoItem;
import br.com.crystianyamakawa.individual.cadastros.PedidoItemRepositorio;
import br.com.crystianyamakawa.individual.cadastros.PedidoRepositorio;
import br.com.crystianyamakawa.individual.cadastros.PessoaRepositorio;
import br.com.crystianyamakawa.individual.cadastros.ProdutoRepositorio;

@Controller
public class PedidoItemControle {
	

	private PedidoItemRepositorio pedidoItemRepo; 
	private ProdutoRepositorio produtoRepo; 
	
	
	public PedidoItemControle(PedidoItemRepositorio pedidoItemRepo, ProdutoRepositorio produtoRedo) {
		this.pedidoItemRepo = pedidoItemRepo;
		this.produtoRepo = produtoRedo;
	}
	

	@GetMapping("/cadastros/pedidoItens/{id}")
	public String alterarPedidoItem(@PathVariable("id") long id, Model model) {
		Optional<PedidoItem> pedidoItemOpt = pedidoItemRepo.findById(id);
		if (!pedidoItemOpt.isPresent()) {
			throw new IllegalArgumentException("Pedido Item Invalido.");
		}
		
		model.addAttribute("pedidoItem", pedidoItemOpt.get());
		model.addAttribute("produtos", produtoRepo.findAll());
			
		
		return "cadastros/pedidoItens/form";
	}

	@PostMapping("/cadastros/pedidoItens/salvar")
	public String salvarPessoa(@ModelAttribute("pedidoItem") PedidoItem pedidoItem, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("pessoas", produtoRepo.findAll());
			return "cadastros/pedidoItens/form";
		}
		
		pedidoItemRepo.save(pedidoItem);
		return "redirect:/cadastros/pedidos";
	}
	
	
	@GetMapping("/cadastros/pedidoItens/excluir/{id}")
	public String excluirPedido(@PathVariable("id") long id, Model model) {
		Optional<PedidoItem> pedidoOpt = pedidoItemRepo.findById(id);
		if (!pedidoOpt.isPresent()) {
			throw new IllegalArgumentException("Pedido Invalido.");
		}
		
		pedidoItemRepo.delete(pedidoOpt.get());
		
		return "redirect:/cadastros/pedidos";
	}
	
}
