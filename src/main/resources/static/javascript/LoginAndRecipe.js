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
					window.location.href = "/messageboard";
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
})