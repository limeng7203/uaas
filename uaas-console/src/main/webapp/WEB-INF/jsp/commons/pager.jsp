<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 分页开始 -->
<div id="cell-pager" class="row">
	<ul class="pager">
		<li><a id="pager-first" href="#">首页</a></li>
		<li><a id="pager-prev" href="#">上一页</a></li>
		<li><a id="pager-next" href="#">下一页</a></li>
		<li><a id="pager-end" href="#">末页</a></li>

		<li id="pager-size">
			<select id="pageSize" onchange="changePagerSize()">
				<option id="page-10">10</option>
				<option id="page-20" selected>20</option>
				<option id="page-50">50</option>
				<option id="page-100">100</option>
			</select>
		</li>
		<li id="pager-info">共 1/14 页</li>
	</ul>
</div>
<!-- 分页结束 -->