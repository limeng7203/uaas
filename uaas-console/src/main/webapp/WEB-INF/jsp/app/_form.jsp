<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="table table-bordered">
	<tbody>
		<tr class="active">
			<td colspan="4"><b>基本信息</b></td>
		</tr>
		<tr>
			<form:hidden path="id"/>
			<td class="active text-right"><label class="control-label"
				for="name">应用名称：<span class="required">*</span></label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="name" class="form-control"  />
				</div>
			</td>
			<td class="active text-right"><label class="control-label "
				for="code">应用编码：<span class="required">*</span></label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="code"  class="form-control" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="active text-right"><label class="control-label"
				for="secret">应用密钥：<span class="required">*</span></label></td>
			<td colspan="3">
				<div class="input-group input-group-sm">
					<form:input path="secret"  class="form-control" />
				</div>
			</td>
		</tr>

		<tr>
			<td class="active text-right"><label class="control-label"
				for="secret">URL：<span class="required">*</span></label></td>
			<td colspan="3">
				<div class="input-group input-group-sm">
					<form:input type="url" path="url"  size="50" class="form-control" />
				</div>
			</td>
		</tr>

		<tr>
			<td class="active text-right"><label class="control-label"
				for="secret">应用描述：</label></td>
			<td colspan="3">
				<div class="input-group input-group-sm">
					<form:textarea path="description" cols="43"  rows="2"  />
				</div>
			</td>
		</tr>
	</tbody>
</table>
