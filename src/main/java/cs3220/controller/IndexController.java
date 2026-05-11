package cs3220.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		@GetMapping("/recipebook")
		public String recipebook(HttpSession session) {
			if (session.getAttribute("user")== null) {
				return "redirect:/";
			}
			return "recipebook";
		}
		
		
}
