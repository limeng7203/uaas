package uaas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 资源<br>
 * 资源：按钮，页面，菜单
 * 
 * @author percy
 *
 */
@Entity(name = "uaas_res")
public class Resource {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 目标URL
	 */
	private String url;
	/**
	 * 控制的权限字符串
	 */
	private String uri;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 级别
	 */
	private Integer level;
	/**
	 * 路径
	 */
	private String path;

	/**
	 * 所属应用
	 */
	private App app;
	/**
	 * 上级资源
	 */
	private Resource parent;

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

	@Column(nullable = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(nullable = false)
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(nullable = false)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(nullable = false)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "app_id")
	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

}
