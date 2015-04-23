<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="table table-bordered">
	<tbody>
		<tr class="active">
			<td colspan="4"><b>基本信息</b></td>
		</tr>
		<tr>
			<form:hidden path="id"/>
			<td class="active text-right" style="vertical-align: middle;">
				 <label for="appId">应用：<span class="required">*</span></label>
			</td>
			<td>
				<div class="input-group input-group-sm">
					<div class="form-group" >
						<form:select id="appId" path="app.id"  class="form-control">
							<option>请选择</option> 
							<form:options items="${apps }" itemLabel="name"  itemValue="id"/>  
						</form:select> 
					</div>
				</div>
			</td>
			<td class="active text-right"  style="vertical-align: middle;">
				<label class="control-label " for="code">角色名称：<span class="required">*</span></label>
			</td>
			<td>
				<div class="input-group input-group-sm">
					<div class="form-group" >
						<form:input path="name"  class="form-control"/>
					</div>
				</div>
			</td>
		</tr>
	</tbody>
</table>
