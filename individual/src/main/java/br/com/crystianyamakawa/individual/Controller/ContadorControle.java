package br.com.crystianyamakawa.individual.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContadorControle {
	int contador;
	public ContadorControle() {
		contador=0;
	}
	
	@GetMapping("/contador")
	public String contador(Model model) {
		contador++;
		model.addAttribute("contador", contador);
		return "contador/index";
	}

}
