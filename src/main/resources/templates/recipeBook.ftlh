<#import "/spring.ftl" as spring>
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
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script src="/javascript/LoginAndRecipe.js"></script>
  </head>
  <body class="container-fluid px-0">
  		<div class="fixed px-4 py-3 d-flex border-bottom justify-content-between">
  		
  		<div class="d-flex align-items-center">
  		<i class="bi me-2 fs-4 bi-fork-knife text-success"></i>
  		<h4 class="fw-bold">RecipeBook</h4>
  		</div>
  		
  		<div class="d-flex gap-3">
  			<h4 class="text-secondary">Hello $(user.name)</h4>
  		<a href="/logout" class="btn btn-success">Logout</a>
  		</div>
  		
  		</div>
  		
  		<div class="container m-5">
  		
  		<div class="d-flex justify-content-between"> 
  		<h2>My Recipes</h2>
  		<div class="position-relative mb-3">
			    			<i class="bi bi-plus fs-3 position-absolute text-white top-50 start-0 translate-middle-y ps-3"></i>
			    		<a href="/addrecipe" class="btn btn-success ps-5">Add Recipe</a>
			    		</div>
  		
  		</div>
  		<p class="text-secondary">Manage your recipes</p>
  			<div class="d-flex justify-content-between border rounded p-3 shadow-sm ">
  				<div class="d-flex flex-column">
  					<h5>Sphagetti</h5>
  					<p class="text-secondary">Ingredients:</p>
  				</div>
  				
  				<div class="d-flex gap-3"> 
	  				<div class="position-relative mb-3">
				    	<i class="bi bi-trash fs-4 position-absolute text-white top-50 start-0 translate-middle-y ps-3"></i>
				    	<a href="/addrecipe" class="btn btn-danger ps-5">Delete</a>
				  	</div>
				  	<div class="position-relative mb-3">
				    	<i class="bi bi-pencil fs-4 position-absolute text-white top-50 start-0 translate-middle-y ps-3"></i>
				    	<a href="/addrecipe" class="btn btn-primary ps-5">Edit</a>
				  	</div>
  				</div>
  				
  			</div>
  		</div>
  		
  </body>
</html>