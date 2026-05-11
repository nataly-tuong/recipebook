package cs3220.dto;

import java.util.ArrayList;
import java.util.List;

import cs3220.model.RecipeEntry;

public class RecipeEntryDto {
	private Integer id;
	private String name;
	private List<String> ingredients = new ArrayList<>();
	
	private String userName;
	
	public RecipeEntryDto() {
		
	}
	
	public RecipeEntryDto(RecipeEntry recipe) {
		id = recipe.getId();
		name = recipe.getName();
		ingredients = recipe.getIngredients();
		userName = recipe.getUser().getName();
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
	
	
}
