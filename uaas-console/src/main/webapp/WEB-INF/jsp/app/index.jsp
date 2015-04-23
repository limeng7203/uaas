<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${pageContext.request.contextPath }/images/favicon.ico">
<script src="${pageContext.request.contextPath }/scripts/jquery/jquery-2.1.3.min.js"></script>
<script src="${pageContext.request.contextPath }/scripts/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/scripts/dashboard/docs.min.js"></script>
<script src="${pageContext.request.contextPath }/scripts/dashboard/ie10-viewport-bug-workaround.js"></script>
<script src="${pageContext.request.contextPath }/scripts/dashboard/ie-emulation-modes-warning.js"></script>

<link href="${pageContext.request.contextPath }/scripts/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/scripts/dashboard/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/scripts/commons/css/core.css" rel="stylesheet">

<script src="${pageContext.request.contextPath }/scripts/commons/js/url-util.js"></script>
<script src="${pageContext.request.contextPath }/scripts/commons/js/menu.js"></script>
<script src="${pageContext.request.contextPath }/scripts/commons/js/pager.js"></script>

<script type="text/javascript">
	/**
	 * 初始化页面
	 */
	$(function() {

		// 高亮菜单
		setActiveMenu("menu-app");
		// 初始化分页组件
		init();
	});
	
	function init() {
		var isContainsPageInfo = ${null == page};
		if (isContainsPageInfo) {
			alert("不包含分页信息");
			return;
		}
		pager.page = ${page.number};
		pager.size = ${page.size};
		pager.elementNumber = ${page.numberOfElements};
		pager.totalPages = ${page.totalPages};
		pager.totalElements = ${page.totalElements};
		pager.url = window.location.href.toString();
		pager.queryString = window.location.search;
		initPager();
		
	}

	/**
	 * 启用/禁用
	 */
	function changeState(id) {
		var url = "./rest/enabled/" + id;
		$.post(url, function(data, textStatus) {
			if (false == data) {
				alert("失败");
			} else {
				 location.reload();
			}
		}, "json");
	}
	
	/**
	 * 删除
	 */
	function deleteApp(id) {
		var url = "./rest/delete/" + id;
		$.post(url, function(data, textStatus) {
			if (false == data) {
				alert("失败");
			} else {
				 location.reload();
			}
		}, "json");
	}
	
</script>
<title>权限管理系统</title>
</head>
<body>
	<%@include file="../commons/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="../commons/menu.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="page-header">应用管理</h2>

				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath }/">首页</a></li>
					<li class="active">应用列表</li>
				</ol>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">操作区</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-10">
								<form action="${pageContext.request.contextPath }/app/queryByName" method="get">
									<span>应用名称：</span> <input type="text"
										name="name" /> <input type="submit" class="btn btn-primary"
										value="查询" />
								</form>
							</div>
							<div class="col-xs-2">
								<a class="btn btn-primary" href="./create">添加</a>
							</div>
						</div>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="15%" style="text-align: center;">应用名称</th>
								<th width="10%" style="text-align: center;">应用编码</th>
								<th width="10%" style="text-align: center;">应用状态</th>
								<th width="40%" style="text-align: center;">URL</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.content }">
								<tr>
									<td><a href="${pageContext.request.contextPath }/app/info/${item.id}">${item.name }</a></td>
									<td>${item.code }</td>
									<td align="center"><c:out
											value="${item.state ==1?'启用':'禁用'}"></c:out></td>
									<td>${item.url }</td>
									<td align="center"><a href="#" onclick="changeState(${item.id })"><c:out
												value="${item.state ==1?'禁用':'启用'}"></c:out></a> <c:out
											value="&nbsp;&nbsp;" escapeXml="false"></c:out> <a href="#"
										onclick="deleteApp(${item.id })"><c:out value="删除"></c:out></a> <c:out
											value="&nbsp;&nbsp;" escapeXml="false"></c:out> <a href="#"
										onclick="deleteApp(${item.id })"><c:out value="管理员"></c:out></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<%@include file="../commons/pager.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>