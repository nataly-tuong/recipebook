package cs3220.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cs3220.model.UserEntry;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
		@GetMapping("/")
		public String index(HttpSession session) {
			if (session.getAttribute("user")!= null) {
				return "recipebook";
			}
			
			return "index";
		}
		
		@GetMapping("/recipebook")
		public String recipebook(Model model, HttpSession session) {
			if (session.getAttribute("user")== null) {
				return "redirect:/";
			}
			
			UserEntry user = (UserEntry) session.getAttribute("user");
			
			model.addAttribute("user", user);
			return "recipebook";
		}
		
		
}
