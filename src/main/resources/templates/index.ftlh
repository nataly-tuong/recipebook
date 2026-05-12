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
  
  	<div id="loginSection">
  		<div class="row vh-100 g-0">
  			<div class="col-lg-6 d-none d-lg-flex flex-column bg-white text-black p-3">
  				<!-- picture from https://www.pexels.com/photo/elegant-plate-presentation-at-a-gourmet-event-29990039/ -->
  				<div class="leftPicture flex-grow-1 rounded-4">
  				</div>
  			</div>
  			
  			
  			<div class="col-12 col-lg-6 py-3 px-5 d-flex justify-content-center justify-content-center align-items-center bg-white">
			    <div class="loginCard d-flex flex-column justify-content-center">
			    		<div class='d-flex gap-2'>
			    			<i class="bi bi-fork-knife"></i>
			    			<i class="bi bi-egg-fried"></i>
			    			<i class="bi bi-basket"></i>
			    			<i class="bi bi-beaker"></i>
			    			
			    		</div>
			    		
			    		<h2>Welcome</h2>
			    	<p class="text-secondary mb-4">Sign in to join the RecipeBook community</p>
			    	
			    	<form id="loginForm">
			    		<h5>Email</h5>
			    		<div class="position-relative mb-3">
			    			<i class="bi bi-envelope position-absolute text-secondary top-50 start-0 translate-middle-y ps-3"></i>
			    		<input class="w-100 ps-5 px-2 form-control" placeholder="Enter your email..." type="email" name="email" id="loginEmail"/>
			    		</div>
			    	
			    		
			    		<h5>Password</h5>
			    		<div class="position-relative mb-3">
			    			<i class="bi bi-lock position-absolute text-secondary top-50 start-0 translate-middle-y ps-3"></i>
			    		<input class="w-100 ps-5 px-2 form-control" placeholder="Enter your password..." type="password" name="password" id="loginPassword"/>
			    		</div>
			    		<div class="systemMessage" class="text-danger fw-bold mb-2"></div>
			    		<button type="submit" class="mt-3 btn btn-success w-100 shadow-sm">Sign In</button>
			    	</form>
			    		<hr/>
			    		<p class="text-center text-secondary">Don't have account? <button type="button" id="showRegisterButton" class="btn btn-link p-0 align-baseline">Register</button></p>
			    		
			    </div>
			</div>
  		</div>
  	</div>
  	
  	<div id="registerSection" style="display:none;">
  		<div class="row vh-100 g-0">
  			<div class="col-lg-6 d-none d-lg-flex flex-column bg-white text-black p-3">
  				<!-- picture from https://www.pexels.com/photo/assorted-fresh-vegetables-and-mushrooms-on-a-kitchen-counter-37172956/ -->
  				<div class="leftPictureRegister flex-grow-1 rounded-4">
  				</div>
  			</div>
  			
  			
  			<div class="col-12 col-lg-6 py-3 px-5 d-flex justify-content-center align-items-center bg-white">
			    <div class="loginCard d-flex flex-column justify-content-center">
			    		<div class='d-flex gap-2'>
			    			<i class="bi bi-fork-knife"></i>
			    			<i class="bi bi-egg-fried"></i>
			    			<i class="bi bi-basket"></i>
			    			<i class="bi bi-beaker"></i>
			    			
			    		</div>
			    		
			    		<h2>Create Account</h2>
			    	<p class="text-secondary mb-4">Join the BookRecipe community</p>
			    	
			    	<form id="registerForm">
			    		<h5>Name</h5>
			    		<div class="position-relative mb-3">
			    			<i class="bi bi-person position-absolute text-secondary top-50 start-0 translate-middle-y ps-3"></i>
			    		<input class="w-100 ps-5 px-2 form-control" placeholder="Enter your name..." type="text" name="name" id="registerName"/>
			    		</div>
			    		
			    		<h5>Email</h5>
			    		<div class="position-relative mb-3">
			    			<i class="bi bi-envelope position-absolute text-secondary top-50 start-0 translate-middle-y ps-3"></i>
			    		<input class="w-100 ps-5 px-2 form-control" placeholder="Enter your email..." type="email" name="email" id="registerEmail"/>
			    		</div>
			    		
			    		<h5>Password</h5>
			    		<div class="position-relative mb-3">
			    			<i class="bi bi-lock position-absolute text-secondary top-50 start-0 translate-middle-y ps-3"></i>
			    		<input class="w-100 ps-5 px-2 form-control" placeholder="Enter your password..." type="password" name="password" id="registerPassword"/>
			    	
			    		</div>
			    		<div class="systemMessage" class="text-danger fw-bold mb-2"></div>
			    		<button type="submit" class="mt-3 btn btn-success w-100 shadow-sm">Register</button>
			    	</form>
			    		<hr/>
			    		<p class="text-center text-secondary">Already have an account? <button type="button" id="showLoginButton" class="btn btn-link p-0 align-baseline">Login</button></p>
			    		
			    </div>
			</div>
  		</div>
  	</div>
  	
  
  		
  </body>
</html>