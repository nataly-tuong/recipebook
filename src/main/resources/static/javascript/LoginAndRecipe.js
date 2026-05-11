$(document).ready(function() {
	$("#showRegisterButton").click(function() {
		$("#registerSection .systemMessage").text("");
		$("#loginSection").hide();
		$("#registerSection").show();
	});
	
	$("#showLoginButton").click(function () {
		$("#loginSection .systemMessage").text("");
		$("#registerSection").hide();
		$("#loginSection").show();
	});
	
	$("#loginForm").submit(function (event) {
		event.preventDefault();
		
		$.ajax({
			url: "/api/login",
			type: "POST",
			contentType: "application/json",
			
			data: JSON.stringify({
				email: $("#loginEmail").val(),
				password: $("#loginPassword").val()
			}),
			
			success: function (result) {
				if (result === "success") {
					window.location.href = "/recipebook";
				}
				else {
					$("#loginSection .systemMessage")
						.removeClass("text-success")
						.addClass("text-danger")
						.text(result);
				}
			},
			error: function (xhr,status,error) {
				console.log("xhr:"+xhr);
				console.log("status:"+status);
				console.log("error"+error);
			}
		});
	});
	
	$("#registerForm").submit(function (event) {
		event.preventDefault();
		
		$.ajax({
			url: "/api/register",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({
				email: $("#registerEmail").val(),
				name: $("#registerName").val(),
				password: $("#registerPassword").val()
			}),
			success: function (result) {
				if (result === "success") {
					$("#loginSection .systemMessage")
						.removeClass("text-danger")
						.addClass("text-success")
						.text("Registration successful. You may log in now.")
						
					$("#registerEmail").val("");
					$("#registerName").val("");
					$("#registerPassword").val("");
					
					$("#registerSection").hide();
					$("#loginSection").show();
				}
				else {
					$("#registerSection .systemMessage")
						.removeClass("text-success")
						.addClass('text-danger')
						.text(result);
				}
			},
			error: function (xhr,status,error) {
							console.log("xhr:"+xhr);
							console.log("status:"+status);
							console.log("error"+error);
						}
			});
		});
		
	if ($("#recipeList").length>0) {
		autoGenerateRecipes();
	}
	
	$("#showAddRecipeButton").click(function () {
		$("#recipeModalTitle").text("Add Recipe");
		
		$("#recipeId").val("");
		$("#recipeName").val("");
		$("#recipeIngredients").val("");
		
		let modal = new bootstrap.Modal(document.getElementById("recipeModal"));
		modal.show();
	});
	
	$("#recipeForm").submit(function (event) {
		event.preventDefault();
		let recipeId = $("#recipeId").val();
		let recipeData= {
			name: $("#recipeName").val(),
			ingredients: $("#recipeIngredients").val().split(",")
		};
		
		let url = "/api/addRecipe";
		let type = "POST";
		
		if (recipeId !== "") {
			url = "/api/editRecipe/" + recipeId;
			type = "PUT";
		}
		
		$.ajax({
			url: url,
			type: type, 
			contentType: "application/json",
			data: JSON.stringify(recipeData),
			
			success: function (result) {
				if (result === "success") {
					bootstrap.Modal
						.getInstance(document.getElementById("recipeModal"))
						.hide();
						
					autoGenerateRecipes();
				}
				else {
					console.log(result);
				}
			},
			error: function (xhr,status,error) {
										console.log("xhr:"+xhr);
										console.log("status:"+status);
										console.log("error"+error);
									}
			});
		});
		
		$("#logoutButton").click(function () {
			$.ajax({
				url: "/api/logout",
				type: "POST",
				
				success: function (result) {
					if (result === "success") {
						window.location.href = "/";
					}
				},
				error: function (xhr,status,error) {
											console.log("xhr:"+xhr);
											console.log("status:"+status);
											console.log("error"+error);
										}
			});
		});
	});
	
	function autoGenerateRecipes() {
		$.ajax({
			url: "/api/recipes",
			type: "GET",
			
			success: function (recipes) {
				let recipeList = $("#recipeList");
				
				recipeList.empty();
				
				$.each(recipes, function (index, recipe) {
					let card = $("<div class='d-flex justify-content-between border rounded p-3 shadow-sm mb-3'></div>");
					
					let leftSide = $("<div></div>");
					
					leftSide.append("<h5>"+recipe.name+"</h5>");
					leftSide.append("<p class='text-secondary mb-1'>Ingredients:</p>");
					
					let ingredientList = $("<ul></ul>");
					
					$.each(recipe.ingredients, function (i, ingredient) {
						ingredientList.append("<li>"+ingredient.trim()+"</li>");
						
					});
					
					leftSide.append(ingredientList);
					
					let buttonSide = $("<div class='d-flex gap-2 align-items-start'></div>");
					let deleteButton = $("<button class='btn btn-danger btn-sm'>Delete</button>");
					
					deleteButton.click(function () {
						deleteRecipe(recipe.id);
					});
					
					let editButton = $("<button class='btn btn-primary btn-sm'>Edit</button>");
					
					editButton.click(function() {
						$("#recipeModalTitle").text("Edit Recipe");
						
						$("#recipeId").val(recipe.id);
						$("#recipeName").val(recipe.name);
						$("#recipeIngredients").val(recipe.ingredients.join(", "));
						
						let modal = new bootstrap.Modal(document.getElementById("recipeModal"));
						modal.show();
					});
					
					buttonSide.append(deleteButton);
					buttonSide.append(editButton);
					card.append(leftSide);
					card.append(buttonSide);
					
					recipeList.append(card);
				});
			},
			
			error: function (xhr,status,error) {
														console.log("xhr:"+xhr);
														console.log("status:"+status);
														console.log("error"+error);
													}
		});
	}
	
	function deleteRecipe(recipeId) {
		$.ajax({
			url: "/api/deleteRecipe/"+recipeId, 
			type: "DELETE",
			
			success: function(result) {
				if (result === "success") {
					autoGenerateRecipes();
				}
				else {
					console.log(result);
				}
			},
			error: function (xhr,status,error) {
																console.log("xhr:"+xhr);
																console.log("status:"+status);
																console.log("error"+error);
															}
		});
}