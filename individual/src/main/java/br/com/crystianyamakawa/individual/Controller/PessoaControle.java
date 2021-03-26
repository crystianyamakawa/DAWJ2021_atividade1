package br.com.crystianyamakawa.individual.Controller;

import java.util.Optional;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.crystianyamakawa.individual.cadastros.Pessoa;
import br.com.crystianyamakawa.individual.cadastros.PessoaRepositorio;

@Controller
public class PessoaControle {
	
	private PessoaRepositorio pessoaRepo;
	
	public PessoaControle(PessoaRepositorio pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
		
	}
	
	@GetMapping("/cadastros/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return "cadastros/pessoas/index";
	}
	

	@GetMapping("/cadastros/pessoas/nova")
	public String novaPessoa(Model model) {
		model.addAttribute("pessoa", new Pessoa(""));
		return "cadastros/pessoas/form";
	}

	
//	@GetMapping("/cadastros/pessoas/{id}")
//	public String alterarPessoa(@PathVariable("id") long id, Model model) {
//		Optional<Pessoa> pessoaOpt = pessoaRepo.findCompletoById(id);
//		if (!pessoaOpt.isPresent()) {
//			throw new IllegalArgumentException("Pessoa Invalida.");
//		}
//		
//		model.addAttribute("pessoa", pessoaOpt.get());
//		
//		return "cadastros/pessoas/form";
//	}
//
	@PostMapping("/cadastros/pessoas/salvar")
	public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cadastros/pessoas/form";
		}
		
		pessoaRepo.save(pessoa);
		return "redirect:/cadastros/pessoas";
	}
//	
//	
//	@GetMapping("/rh/pessoas/excluir/{id}")
//	public String excluirPessoa(@PathVariable("id") long id, Model model) {
//		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
//		if (!pessoaOpt.isPresent()) {
//			throw new IllegalArgumentException("Pessoa Invalida.");
//		}
//		
//		pessoaRepo.delete(pessoaOpt.get());
//		
//		return "redirect:/rh/pessoas";
//	}
//

}
