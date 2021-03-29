package br.com.crystianyamakawa.individual.Controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.crystianyamakawa.individual.cadastros.Pedido;
import br.com.crystianyamakawa.individual.cadastros.PedidoItem;
import br.com.crystianyamakawa.individual.cadastros.PedidoItemRepositorio;
import br.com.crystianyamakawa.individual.cadastros.PedidoRepositorio;
import br.com.crystianyamakawa.individual.cadastros.Pessoa;
import br.com.crystianyamakawa.individual.cadastros.PessoaRepositorio;
import br.com.crystianyamakawa.individual.cadastros.ProdutoRepositorio;

@Controller
public class PedidoControle {
	private PedidoRepositorio pedidoRepo;
	private PessoaRepositorio pessoaRepo;
	private ProdutoRepositorio produtoRepo;
	private PedidoItemRepositorio pedidoItemRepo; 
	
	
	public PedidoControle(PedidoRepositorio pedidoRepo, PessoaRepositorio pessoaRepo, PedidoItemRepositorio pedidoItemRepo, ProdutoRepositorio produtoRepo) {
		this.pedidoRepo = pedidoRepo;
		this.pessoaRepo = pessoaRepo;
		this.pedidoItemRepo = pedidoItemRepo;
		this.produtoRepo = produtoRepo;
	}
	
	@GetMapping("/cadastros/pedidos")
	public String pessoas(Model model) {
		model.addAttribute("listaPedidos", pedidoRepo.findAll());
		return "cadastros/pedidos/index";
	}

	
	@GetMapping("/cadastros/pedidos/nova")
	public String novaPessoa(Model model) {
		
		model.addAttribute("pedido", new Pedido(LocalDate.of(2021,1,3)));
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("produtos", produtoRepo.findAll());
		return "cadastros/pedidos/editar";
	}

	
	@GetMapping("/cadastros/pedidos/{id}")
	public String alterarPedido(@PathVariable("id") long id, Model model) {
		Optional<Pedido> pedidoOpt = pedidoRepo.findCompletoById(id);
		if (!pedidoOpt.isPresent()) {
			throw new IllegalArgumentException("Pedido Invalido.");
		}
		
		model.addAttribute("pedido", pedidoOpt.get());
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("produtos", produtoRepo.findAll());
		
		
		return "cadastros/pedidos/editar";
	}

	@PostMapping("/cadastros/pedidos/salvar")
	public String salvarPessoa(@ModelAttribute("pedido") Pedido pedido, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("pessoas", pessoaRepo.findAll());
					return "cadastros/pedidos/editar";
		}
		pedido.corrigirItens();
		pedidoRepo.save(pedido);
		return "redirect:/cadastros/pedidos";
	}
	
	
	@GetMapping("/cadastros/pedidos/excluir/{id}")
	public String excluirPedido(@PathVariable("id") long id, Model model) {
		Optional<Pedido> pedidoOpt = pedidoRepo.findById(id);
		if (!pedidoOpt.isPresent()) {
			throw new IllegalArgumentException("Pedido Invalido.");
		}
		
		
		pedidoRepo.delete(pedidoOpt.get());
		
		return "redirect:/cadastros/pedidos";
	}
	
	
	@RequestMapping(value="/cadastros/pedidos/salvar", params = {"removeItem"})
	public String removeItem(Pedido pedido, BindingResult bindingResult, HttpServletRequest req, Model model) {
		final Integer itemIndex = Integer.valueOf(req.getParameter("removeItem"));
		
		pedido.removeItem(itemIndex.intValue());
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("produtos", produtoRepo.findAll());
		return "cadastros/pedidos/editar";
	}
	
	@RequestMapping(value="/cadastros/pedidos/salvar", params = {"addItem"})
	public String addItem(Pedido pedido, BindingResult bindingResult, Model model) {
		PedidoItem item = new PedidoItem("");
		
		item.setPedido(pedido);
		
		pedido.addItem(item);
		
		String fieldId = "itens" + (pedido.getItens().size() - 1) + ".numero";
		model.addAttribute("fieldToFocus", fieldId);
		model.addAttribute("pessoas", pessoaRepo.findAll());
		model.addAttribute("produtos", produtoRepo.findAll());
		
		return "cadastros/pedidos/editar";
	}
}

