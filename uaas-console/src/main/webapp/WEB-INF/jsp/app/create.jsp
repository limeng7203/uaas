<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<script src="../../../scripts/commons/js/menu.js"></script>
<script src="../../../scripts/commons/js/pager.js"></script>
<script src="../../../scripts/commons/js/app/app.js"></script>
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
					<li><a href="/">首页</a></li>
					<li><a href="./">应用列表</a></li>
					<li class="active">应用创建</li>
				</ol>

				<form:form action="./save" method="post" modelAttribute="app">
					
					<div class="table-responsive">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<td colspan="4"><b>基本信息</b></td>
								</tr>
								<tr>
									<td class="active text-right"><label class="control-label">应用名称：<span
											class="required">*</span></label></td>
									<td>
										<div class="input-group input-group-sm">
											<form:input  path="name"/>
										</div>
									</td>
									<td class="active text-right"><label
										class="control-label ">应用编码：<span class="required">*</span></label></td>
									<td>
										<div class="input-group input-group-sm">
											<form:input  path="code"/>
										</div>
									</td>
								</tr>
								<tr>
									<td class="active text-right"><label class="control-label">应用密钥：<span
											class="required">*</span></label></td>
									<td>
										<div class="input-group input-group-sm">
											<form:input  path="secret"/>
										</div>
									</td>
									<td class="active text-right"><label
										class="control-label ">应用描述：</label></td>
									<td>
										<div class="input-group input-group-sm">
											<form:input  path="description"/>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<div class="text-center">
								<input type="submit"  value="创建" class="btn btn-primary"/>
								<a href="./" class="btn btn-default">取消</a>
						</div>

					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>