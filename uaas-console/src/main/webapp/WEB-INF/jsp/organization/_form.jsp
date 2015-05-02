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
			<td>
				<input id="parentId" type="hidden" name="parent.id" />
				<input id="targetDepartment" class="form-control" readonly
	                        placeholder="上级部门" data-toggle="modal"
	                        data-target=".bs-example-modal-sm" style="width: 250px;"/>
	
		           <div id="org-tree" class="modal fade bs-example-modal-sm" tabindex="-1"
		                role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		               <div class="modal-dialog modal-sm">
		                   <div class="modal-content">
		                       <div id="tree">====</div>
		                   </div>
		               </div>
		           </div>
			</td>
		</tr>
		<tr>
			<td class="active text-right"><label class="control-label "
				for="code">部门名称：<span class="required">*</span>
			</label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="name" class="form-control"  style="width: 250px;"/>
				</div>
			</td>
			<td class="active text-right"><label class="control-label"
				for="secret">负责人：</label></td>
			<td>
				<div class="input-group input-group-sm">
					<form:input path="leaderId" class="form-control"  style="width: 250px;"/>
				</div>
			</td>
		</tr>

	</tbody>
</table>
