/**
 * 初始化页面
 */
$(function () {
	
	// 高亮菜单
	setActiveMenu("menu-org");
	// 验证表单
	validateForm();
	// 加载所有部门树结构
	loadOrgTree();
	
});

var aa = [{"id":1,"pid":null,"name":"test","level":1,"state":1,"path":"/test","leaderName":null},{"id":2,"pid":null,"name":"test","level":1,"state":1,"path":"/test","leaderName":null},{"id":3,"pid":null,"name":"test","level":1,"state":1,"path":"/test","leaderName":null},{"id":4,"pid":null,"name":"test","level":1,"state":1,"path":"/test","leaderName":null}];

function loadOrgTree() {
	$('#org-tree').on('show.bs.modal', function (e) {
		  // do something...
		alert("===========");
		
        $.get("./findAll", function (data) {
        	alert(JSON.stringify(""));
            GetFirstNode(data);
        });
	});
}

function validateForm() {
	$("#org-form").validate({
		rules: {
			name: {
				required: true,
				maxlength: 10
			},
			code: {
				required: true,
				maxlength: 10
			},
			secret: {
				required: true,
				minlength: 6,
				maxlength: 20
			},
			url: {
				required: true,
				maxlength: 255
			}
		},
		messages: {
			name: {
				required: "请输入应用名称",
				maxlength: "最大长度不能超过10个字符"
			},
			code: {
				required: "请输入应用编码",
				maxlength: "最大长度不能超过10个字符"
			},
			secret: {
				required: "请输入应用密钥",
				minlength: "最小长度不能低于6个字符",
				maxlength: "最大长度不能超过20个字符"
			},
			url: {
				required: "请输入应用URL",
				maxlength: "最大长度不能超过255个字符"
			}
		}
	});
}