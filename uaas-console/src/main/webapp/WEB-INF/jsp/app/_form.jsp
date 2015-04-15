<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="app-form" action="./save" method="post" modelAttribute="app">

	<div class="table-responsive">
		<table class="table table-bordered">
			<tbody>
				<tr class="active">
					<td colspan="4"><b>基本信息</b></td>
				</tr>
				<tr>
					<td class="active text-right"><label class="control-label" for="name">应用名称：<span
							class="required">*</span></label></td>
					<td>
						<div class="input-group input-group-sm">
							<form:input path="name" />
						</div>
					</td>
					<td class="active text-right"><label class="control-label " for="code">应用编码：<span
							class="required">*</span></label></td>
					<td>
						<div class="input-group input-group-sm">
							<form:input path="code" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="active text-right" ><label class="control-label" for="secret">应用密钥：<span
							class="required">*</span></label></td>
					<td>
						<div class="input-group input-group-sm">
							<form:input path="secret" />
						</div>
					</td>
					<td class="active text-right"><label class="control-label " for="description">应用描述：</label></td>
					<td>
						<div class="input-group input-group-sm">
							<form:input path="description" />
						</div>
					</td>
				</tr>

			</tbody>
		</table>

				<div class="text-center">
					<input type="submit" value="创建" class="btn btn-primary" /> <a
						href="./" class="btn btn-default">取消</a>
				</div>
	</div>
</form:form>