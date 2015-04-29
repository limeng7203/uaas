package uaas.domain;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户组
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_group")
public class Group {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户组名称
	 */
	private String name;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 更新时间
	 */
	private Date updated;

	/**
	 * 用户
	 */
	private List<User> users = new ArrayList<User>();

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

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * <code>@ManyToMany </code>注释表示Teacher 是多对多关系的一端。<br>
	 * <code>@JoinTable</code> <br>
	 * 
	 * <pre>
	 * 
	 * 描述了多对多关系的数据表关系
	 * name:属性指定中间表名称。
	 *  joinColumns 定义中间表与uaas_group 表的外键关系，中间表group_user的group_id 列是uaas_group 表的主键列对应的外键列。
	 *  inverseJoinColumns 属性定义了中间表与另外一端(User)的外键关系。
	 * </pre>
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "uaas_group_user", joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
