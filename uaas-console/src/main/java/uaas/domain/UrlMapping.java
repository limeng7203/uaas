package uaas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * URL<br>
 * 
 * <pre>
 * 用户在创建资源时候，创建该URL
 * 说明：
 * 该部分和UrlMapping主要是为了基于URL访问控制，例如shiro的urlmapping等或者说是spring security...
 * </pre>
 * 
 * @author percy
 *
 */
@Entity
@Table(name = "uaas_url_mapping")
public class UrlMapping {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * URL
	 */
	private String url;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 允许访问名称role["admin", "user"]，当然这里是一个，将来转换为我说的格式
	 */
	private String allowName;
	/**
	 * 允许访问类型：1：角色；2：用户；默认是角色
	 */
	private Integer allowType;
	/**
	 * 应用标识
	 */
	private Long appId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(nullable = false)
	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(nullable = false)
	public String getAllowName() {
		return allowName;
	}

	public void setAllowName(String allowName) {
		this.allowName = allowName;
	}

	@Column(nullable = false)
	public Integer getAllowType() {
		return allowType;
	}

	public void setAllowType(Integer allowType) {
		this.allowType = allowType;
	}

}
