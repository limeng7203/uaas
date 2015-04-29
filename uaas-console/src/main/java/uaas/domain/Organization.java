package uaas.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 部门<br>
 * <pre>
 * 过去一直没仔细研读JPA规范，今天在这里说明一下，
 * 
 * {@code @Entity(name = "xxx")}
 * 
 * 这个注解想必大家都知道的哈，表明这个一个是领域的实体，没错，
 * 但是大家可能对这个name属性不太熟悉，下面是官方说明，我简单翻译一下：
 * 这个是一个可选项，表示的是实体的名称。默认呢是一个不限制的实体名称。这个名称用于
 * 实体的查询语句中。并且这个名称不能使用查询语言中的关键词。
 * 
 * The entity name. Defaults to the unqualified name of the entity class. This name is used to refer to the entity 
 * in queries. The name must not be a reserved literal in the Java Persistence query language.
 * 
 * 但是实际过程中，我使用的spring-data-jpa部分，在继承相应的接口后，例如该实体的仓库接口
 * OrganizationRepo extends JpaRepository中，
 * 如果在使用{@code @Query("from uaas_org org...")}中，
 * 你在使用这个名称uaas_org就是这里指定的名称，如果还使用默认的Organization会报该实体没有映射not mapped异常。。。
 * 
 * 
 * 这里就是我特定告诉大家的，如果既想映射不同的表名称，又想在{@code @Query("from Organization org...")}语句中使用
 * 默认的实体名，那么可以告诉大家一个做法就是使用{@code @Table(name = "xxx")}这个注解，后续我会在其他模块中演示使用的。
 * 
 * 
 * 这个项目尽量演示不同的风格，但是大家在做项目使用尽量规范统一哈，这样维护成本降低了，嘿嘿。
 * 
 * </pre>
 * 
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
	 * 路径ID
	 */
	private String pathId;
	/**
	 * 负责人
	 */
	private Long leaderId;
	/**
	 * 负责人姓名
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
	public String getPathId() {
		return pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
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

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

}
