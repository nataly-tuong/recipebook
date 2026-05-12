<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ExtraCredit2 RecipeBook</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css"
    />
   <script src="https://cdn.jsdelivr.net/npm/jquery@4.0.0/dist/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/assets/css/styles.css" />
    <script src="/assets/javascript/LoginAndRecipe.js"></script>
  </head>
  <body class="container-fluid px-0">
  		<div class="fixed px-4 py-3 d-flex border-bottom justify-content-between">
	  		
	  		<div class="d-flex align-items-center">
		  		<i class="bi me-2 fs-4 bi-fork-knife text-success"></i>
		  		<h4 class="fw-bold">RecipeBook</h4>
	  		</div>
	  		
	  		<div class="d-flex gap-3 align-items-center">
	  			<h5 class="text-secondary mb-0">Hi ${user.name}!</h5>
	  			<button type="button" id="logoutButton" class="btn btn-success">Logout</button>
	  		</div>
  		
  		</div>
  		
  	<div id="systemMessage" class="text-center fw-bold text-danger mb-3"></div>
  	<div class="modal fade" id="recipeModal" tabindex="-1">
  		<div class="modal-dialog">
  			<div class="modal-content">
  				<form id="recipeForm">
  					<div class="modal-header">
  						<h5 class="modal-title" id="recipeModalTitle">Add Recipe</h5>
  						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
  					</div>
  					
  					<div class="modal-body">
  						<input type="hidden" id="recipeId"/>
  						<div class="mb-3">
  							<label for="recipeName" class="form-label fw-bold">Recipe</label>
  							<input type="text" id="recipeName" class="form-control" placeholder="Recipe name"/>
  						</div>
  						
  						<div class="mb-3">
  							<label for="recipeIngredients" class="form-label fw-bold">Ingredients</label>
  							<textarea id="recipeIngredients" class="form-control" rows="6" placeholder="Separate ingredients with commas"></textarea>
  						</div>
  						
  					</div>
  					
  					<div class="modal-footer">
  						<button type="submit" class="btn btn-success" id="saveRecipeButton">Save Recipe
  						</button>
  						
  						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
  						</button>
  					</div>
  				</form>
  			</div>
  		</div>
  	</div>
  	
  	<div id="recipeBookSection">
  		
  		
  		<div class="container m-5">
  		
  		<div class="d-flex justify-content-between"> 
  		<div>
	  		<h2>Our Recipes</h2>
	  		<p class="text-secondary">Manage your recipes</p>
  		</div>
  
  		<div class="position-relative mb-3">
			    			
			    		<button type="button" id="showAddRecipeButton" class="btn btn-success d-flex align-items-center gap-2 px-2 py-0">
			    		<i class="bi bi-plus fs-4"></i>
			    		<span>Add Recipe</span>
			    		</button>
			    		</div>
  		
  		</div>
  		
  			<div id="recipeList"></div>
  				
  		</div>
  	</div>
  	
  		
  </body>
</html>