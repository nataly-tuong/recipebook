package cs3220.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class RecipeEntry {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank (message = "Recipe name is required")
	private String name;
	
	@ElementCollection
	@NotEmpty (message = "At least one ingredient is required.")
	private List<@NotBlank(message = "Ingredient cannot be blank") String> ingredients = new ArrayList<>();
	
	@ManyToOne
	private UserEntry user;
	
	public RecipeEntry() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RecipeEntry(String name, List<String> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public UserEntry getUser() {
		return user;
	}

	public void setUser(UserEntry user) {
		this.user = user;
	}

	
	
}
