package uaas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 角色标记<br>
 * 
 * <pre>
 * 弱关系
 * 相当于角色组
 * 一类义务人
 * 
 * </pre>
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_role_tag")
public class RoleTag {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 包括的角色
	 */
	private List<Role> roles = new ArrayList<Role>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "uaas_role_tag", joinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
