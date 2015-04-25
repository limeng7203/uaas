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
<script src="${pageContext.request.contextPath }/scripts/jquery-treegrid/jquery.treegrid.min.js"></script>
<script src="${pageContext.request.contextPath }/scripts/jquery-treegrid/jquery.treegrid.bootstrap3.js"></script>

<link href="${pageContext.request.contextPath }/scripts/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/scripts/dashboard/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/scripts/commons/css/core.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/scripts/jquery-treegrid/css/jquery.treegrid.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/scripts/commons/js/menu.js"></script>

<script type="text/javascript">
	/**
	 * 初始化页面
	 */
	$(function() {

		// 高亮菜单
		setActiveMenu("menu-org");
		// 初始化分页组件
		init();
	});

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
				<h2 class="page-header">部门管理</h2>

				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath }/">首页</a></li>
					<li class="active">部门列表</li>
				</ol>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">操作区</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-11">
							</div>
							<div class="col-xs-1">
								<a class="btn btn-primary" href="./create">添加</a>
							</div>
						</div>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="15%" style="text-align: center;">部门名称</th>
								<th width="15%" style="text-align: center;">部门负责人</th>
								<th width="10%" style="text-align: center;">部门状态</th>
								<th width="40%" style="text-align: center;">部门位置</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>