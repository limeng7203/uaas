<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="table table-bordered">
	<tbody>
		<tr class="active">
			<td colspan="4"><b>基本信息</b></td>
		</tr>
		<tr>
			<form:hidden path="id" />
			<td class="active text-right"><label class="control-label"
				for="name">上级部门：</label></td>
			<td colspan="3">
				<div class="input-group input-group-sm">
					<form:input path="name" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="active text-right"><label class="control-label "
				for="code">部门名称：<span class="required">*</span>
			</label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="name" />
				</div>
			</td>
			<td class="active text-right"><label class="control-label"
				for="secret">负责人：</label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="leaderId" />
				</div>
			</td>
		</tr>

	</tbody>
</table>
