package br.com.crystianyamakawa.individual.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControle {
		public AppControle() {
		}
		
		@GetMapping("/")
		public String app(Model model) {
			//contador++;
			//model.addAttribute("contador", contador);
			return "index";
		}

}
