package cs3220.dto;

import cs3220.model.UserEntry;
import jakarta.validation.constraints.NotBlank;

public class UserEntryDto {
	private Integer id;

	@NotBlank (message = "Name is required")
	private String name;
	
	@NotBlank (message = "Email is required")
	private String email;
	
	@NotBlank (message = "Password is required")
	private String password;
	public UserEntryDto() {
		
	}
	
	public UserEntryDto(UserEntry user) {
		id = user.getId();
		email = user.getEmail();
		name = user.getName();
		password = user.getPassword();
	}
	
	public UserEntry newUser() {
		UserEntry user = new UserEntry();
		user.setEmail(email);
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		return user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
