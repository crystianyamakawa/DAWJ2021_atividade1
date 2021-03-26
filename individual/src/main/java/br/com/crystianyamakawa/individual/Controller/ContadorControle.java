package br.com.crystianyamakawa.individual.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ContadorControle {
	
	@GetMapping("/contador")
	public String contador(Model model) {
		model.addAttribute("contador", 1000);
		return "contador/index";
	}

}
