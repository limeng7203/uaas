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
import javax.persistence.ManyToOne;

/**
 * 角色
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_role")
public class Role {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 状态：1：正常；0：停用；-1：删除
	 */
	private Integer state;

	/**
	 * 所属应用
	 */
	private App app;
	/**
	 * 用户集
	 */
	private List<User> users = new ArrayList<User>();
	/**
	 * 资源集
	 */
	private List<Resource> resources = new ArrayList<Resource>();

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

	@Column(nullable = false, length = 20)
	public String getCode() {
		return code;
	}

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "app_id")
	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "uaas_user_role", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "uaas_role_res", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "res_id", referencedColumnName = "id") })
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
