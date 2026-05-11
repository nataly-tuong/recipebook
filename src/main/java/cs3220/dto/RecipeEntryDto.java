package cs3220.dto;

import java.util.ArrayList;
import java.util.List;

import cs3220.model.RecipeEntry;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class RecipeEntryDto {
	private Integer id;
	
	@NotBlank (message = "Recipe name is required")
	private String name;
	
	@NotEmpty (message = "At least one ingredient is required.")
	private List<@NotBlank(message = "Ingredient cannot be blank") String> ingredients = new ArrayList<>();
	
	private Integer userId;
	private String userName;


	public RecipeEntryDto() {
		
	}
	
	public RecipeEntryDto(RecipeEntry recipe) {
		id = recipe.getId();
		name = recipe.getName();
		ingredients = recipe.getIngredients();
		
		if (recipe.getUser()!=null) {
			userId = recipe.getUser().getId();
			userName = recipe.getUser().getName();
		}
	}
	
	public RecipeEntry newRecipe() {
		RecipeEntry recipe = new RecipeEntry();
		
		recipe.setId(id);
		recipe.setName(name);
		recipe.setIngredients(ingredients);
		
		return recipe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
