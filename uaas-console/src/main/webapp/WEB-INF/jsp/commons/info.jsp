<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row" style="margin: 10px 0px 20px 0px;">
	<c:if test="${info != null}">
			操作信息：<span style="color: green;"><c:out
				value="${info == null? '操作成功':info }"></c:out></span>
		<br>
	</c:if>
</div>