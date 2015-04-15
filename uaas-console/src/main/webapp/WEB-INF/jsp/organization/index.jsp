<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../../../images/favicon.ico">
<script src="../../../scripts/jquery/jquery-2.1.3.min.js"></script>
<script src="../../../scripts/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<script src="../../../scripts/dashboard/docs.min.js"></script>
<script src="../../../scripts/dashboard/ie10-viewport-bug-workaround.js"></script>
<script src="../../../scripts/dashboard/ie-emulation-modes-warning.js"></script>

<link href="../../../scripts/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../../../scripts/dashboard/dashboard.css" rel="stylesheet">
<link href="../../../scripts/commons/css/core.css" rel="stylesheet">
<title>权限管理系统</title>
</head>
<body>
	<%@include file="../commons/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="../commons/menu.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h1 class="page-header">整体风格预览</h1>
				<h2 class="page-header">部门管理</h2>

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li class="active">部门管理</li>
				</ol>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">操作区</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-11">
								<span>主题词：</span> <input id="theme_query_word" type="text"
									name="word" /> <input type="button" class="btn btn-primary"
									id="theme_query_button" value="查询" onclick="theme_init()" />
							</div>
							<div class="col-xs-1">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#create-theme">添加</button>
							</div>
						</div>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>主键</th>
								<th>主题</th>
								<th>拼音</th>
								<th>搜索频率</th>
								<th>数据状态</th>
								<th>更新时间</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="theme-content">
						</tbody>
					</table>
				</div>
				<%@include file="../commons/pager.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>