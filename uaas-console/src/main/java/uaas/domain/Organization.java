package uaas.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 部门
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_org")
public class Organization {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 部门编号
	 */
	private String code;
	/**
	 * 部门级别
	 */
	private Integer level;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 负责人
	 */
	private Long leaderId;
	/**
	 * 负责人姓名
	 */
	private String leaderName;

	/**
	 * 上级部门
	 */
	private Organization parent;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, length = 10)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(nullable = false)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(nullable = false)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

}
