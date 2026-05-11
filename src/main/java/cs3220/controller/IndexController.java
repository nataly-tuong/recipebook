package cs3220.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cs3220.model.UserEntry;
import cs3220.repository.RecipeEntryRepository;
import cs3220.repository.UserEntryRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
		@GetMapping("/")
		public String index() {
			return "index";
		}
	
		public String messageBoard(HttpSession session) {
			if (session.getAttribute("user")== null) {
				return "redirect:/";
			}
			return "recipebook";
		}
}
