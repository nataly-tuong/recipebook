package cs3220.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs3220.dto.RecipeEntryDto;
import cs3220.dto.UserEntryDto;
import cs3220.model.RecipeEntry;
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
	
	@GetMapping("/recipes")
	public List<RecipeEntryDto> getRecipes(HttpSession session) {
		UserEntry user = (UserEntry) session.getAttribute("user");
		
		List<RecipeEntryDto> result = new ArrayList<>();
		for (RecipeEntry recipe : recipeRepo.findAll()) {
			result.add(new RecipeEntryDto(recipe));
		}
		
		result.sort(Comparator.comparing(RecipeEntryDto::getName));
		return result;
	}
	
	@PostMapping("/addRecipe")
	public String addRecipe(@RequestBody RecipeEntryDto dto, HttpSession session) {
		UserEntry user = (UserEntry) session.getAttribute("user");
		
		RecipeEntry recipe = dto.newRecipe();
		recipe.setUser(user);
		
		recipeRepo.save(recipe);
		return "success";
	}
	
	
	@PutMapping("/editRecipe/{id}")
	public String editRecipe(@PathVariable Integer id, @RequestBody RecipeEntryDto dto, HttpSession session) {
		UserEntry user = (UserEntry) session.getAttribute("user");
		
		RecipeEntry recipe = recipeRepo.findById(id).orElse(null);
		
		recipe.setName(dto.getName());
		recipe.setIngredients(dto.getIngredients());
		
		recipeRepo.save(recipe);
		return "success";
	}
	
	@DeleteMapping("/deleteRecipe/{id}")
	public String deleteRecipe(@PathVariable Integer id, HttpSession session) {
		UserEntry user = (UserEntry) session.getAttribute("user");
		
		RecipeEntry recipe = recipeRepo.findById(id).orElse(null);
		
		recipeRepo.delete(recipe);
		return "success";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "success";
	}
	
}