package cs3220.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserEntry {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank (message = "Name is required")
	private String name;
	
	@NotBlank (message = "Email is required")
	private String email;
	
	@NotBlank (message = "Password is required")
	private String password;
	
	public UserEntry() {
		
	}
	
	public UserEntry(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
