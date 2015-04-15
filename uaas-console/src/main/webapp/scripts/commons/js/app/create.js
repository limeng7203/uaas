/**
 * 初始化页面
 */
$(function () {
	
	// 高亮菜单
	setActiveMenu("menu-app");
	// 验证表单
	validateForm();
	
});

function validateForm() {
	$("#app-form").validate({
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
				minlength: "最大长度不能超过20个字符"
			}
		}
	});
}