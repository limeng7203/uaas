<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu" class="col-sm-3 col-md-2 sidebar">
	<h4>
		<span style="margin-left: -15px;"
			class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;基础管理
	</h4>
	<ul class="nav nav-sidebar">
		<li id="menu-org"><a href="${contextPath }/organization/">部门管理</a></li>
		<li id="menu-user"><a href="${contextPath }/user/">用户管理</a></li>
		<li id="menu-role"><a href="${contextPath }/role/">角色管理</a></li>
		<li id="menu-app"><a href="${contextPath }/app/">应用管理</a></li>
		<li id="menu-res"><a href="${contextPath }/resource/">资源管理</a></li>
	</ul>
	<h4>
		<span style="margin-left: -15px;"
			class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;授权管理
	</h4>
	<ul class="nav nav-sidebar">
		<li id="menu-user-auth"><a href="${contextPath }/user-auth/">用户授权</a></li>
		<li id="menu-role-auth"><a href="${contextPath }/role-auth/">角色授权</a></li>
		<li id="menu-res-auth"><a href="${contextPath }/res-auth/">资源授权</a></li>
	</ul>
</div>