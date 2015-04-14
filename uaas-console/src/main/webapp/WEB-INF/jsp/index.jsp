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
	<jsp:include page="./commons/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<h4>
					<span style="margin-left: -15px;"
						class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;评测数据集
				</h4>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#" onclick="theme()">主题词管理</a></li>
					<li><a href="document.html">文档管理</a></li>
					<li><a href="association.html">相关度管理</a></li>
				</ul>
				<h4>
					<span style="margin-left: -15px;"
						class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;评测内容
				</h4>
				<ul class="nav nav-sidebar">
					<li><a href="">准确度评测</a></li>
					<li><a href="">搜全率评测</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="page-header">主题词管理</h2>

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li class="active">主题词管理</li>
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
				<!-- 分页开始 -->
				<div id="cell-pager" class="row">
					<nav>
					<ul class="pager">
						<li><a href="#" onclick="first()">首页</a></li>
						<li><a href="#" onclick="previous()">上一页</a></li>
						<li><a href="#" onclick="next()">下一页</a></li>
						<li><a href="#" onclick="end()">末页</a></li>
						<li id="theme_page-info">共 1/14 页</li>
					</ul>
					</nav>
				</div>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>
</body>
</html>