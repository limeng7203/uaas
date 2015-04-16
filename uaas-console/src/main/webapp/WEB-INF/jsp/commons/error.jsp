<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row" style="margin: 10px 0px 20px 0px;">
	<c:if test="${error != null}">
						业务异常：<br>
						异常信息：<span style="color: red;"><c:out
				value="${error.message == null? '未知异常' : error.message }"></c:out></span>
		<br>
						异常描述：<span style="color: red;"><c:out
				value="${error.description == null? '未知描述' : error.description }"></c:out></span>
	</c:if>
</div>