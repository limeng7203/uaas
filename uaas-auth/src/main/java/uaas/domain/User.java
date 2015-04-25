package uaas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "test_user")
public class User {
	private Long id;
	private String username;
	private String path;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false, unique = true)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
