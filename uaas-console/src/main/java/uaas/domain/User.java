package uaas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_user")
public class User {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 职称
	 */
	private String title;
	/**
	 * 职位级别
	 */
	private Integer level;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 直属领导Id
	 */
	private Long leaderId;
	/**
	 * 直属领导姓名
	 */
	private String leaderName;
	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 更新时间
	 */
	private Date updated;

	/**
	 * 部门
	 */
	private Long organizationId;
	/**
	 * 部门
	 */
	private String organizationName;
	/**
	 * 部门
	 */
	private String organizationPath;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false, length = 10)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = true, length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(nullable = true, length = 20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = true)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(nullable = true)
	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	@Column(nullable = true)
	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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

	@Column(nullable = true)
	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Column(nullable = true)
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@Column(nullable = true)
	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

}
