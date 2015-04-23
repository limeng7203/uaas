<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script src="${pageContext.request.contextPath }/scripts/commons/js/menu.js"></script>
<script src="${pageContext.request.contextPath }/scripts/commons/js/pager.js"></script>

<script
	src="${pageContext.request.contextPath }/scripts/jquery-validation-1.13.1/dist/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(function() {
		$(":input").attr("disabled","disabled");
	});
</script>
<title>权限管理系统</title>
</head>
<body>
	<%@include file="../commons/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="../commons/menu.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="page-header">角色管理</h2>

				<ol class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/role/">角色列表</a></li>
					<li class="active">角色信息</li>
				</ol>
				<%@include file="../commons/info.jsp"%>
				<%@include file="../commons/error.jsp"%>
				<form:form id="app-form" modelAttribute="role">
					<div class="table-responsive">
					
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<td colspan="4"><b>基本信息</b></td>
								</tr>
									
							</tbody>
						</table>

						<div class="text-center">
							<a href="${pageContext.request.contextPath }/role/update/${app.id }" class="btn btn-primary">更新</a> <a
								href="${pageContext.request.contextPath }/role/" class="btn btn-default">取消</a>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>