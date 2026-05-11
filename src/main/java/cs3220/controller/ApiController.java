package cs3220.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs3220.dto.UserEntryDto;
import cs3220.model.UserEntry;
import cs3220.repository.RecipeEntryRepository;
import cs3220.repository.UserEntryRepository;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {
	// Connects to the repository classes
	@Autowired
	private UserEntryRepository userRepo;
	@Autowired
	private RecipeEntryRepository recipeRepo;
	
	@PostMapping("/login")
	public String login(@RequestBody UserEntryDto dto, HttpSession session) {
		UserEntry user = userRepo.findByEmail(dto.getEmail());
		
		if ((user==null) || !user.getPassword().equals(dto.getPassword())) {
			return "Invalid email or password";
		}
		session.setAttribute("user", user);
		return "success";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserEntryDto dto) {
		if (userRepo.findByEmail(dto.getEmail()) != null) {
			return "Email already exists";
		}
		// dto to entity
		UserEntry user = dto.newUser();
		userRepo.save(user);
		return "success";
	}
}