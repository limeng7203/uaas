package uaas.service.criteria;

public class RoleCriteria {
	private String name;
	private Long appId;
	private Integer page;
	private Integer size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Integer getPage() {
		return (null == page ? 0 : page);
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return (null == size ? 20 : (size > 100 ? 100 : size));
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
