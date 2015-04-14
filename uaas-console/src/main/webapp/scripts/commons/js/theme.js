function theme_create() {
	var word = $("#theme_create_word").val();
	var pinyin = $("#theme_create_pinyin").val();
	var searchFrequency = $("#theme_create_searchFrequency").val();
	var data = {
		"word" : word,
		"pinyin" : pinyin,
		"searchFrequency" : searchFrequency
	};
	$.post("../theme/create", data, function(result, status) {
		alert("创建成功！");
		$("#theme_create_word").val('');
		$("#theme_create_pinyin").val('');
		$("#theme_create_searchFrequency").val('');
		theme();
	}, "json");

}

$(function() {
	theme();
});

function theme(){
	$("#theme_query_word").val('');
	theme_init();
}

function theme_init() {
	var total = 0;
	var data = null;
	var url = "../theme/queryThemesCount?word=" + $("#theme_query_word").val();
	$.get(url, function(result) {
		computerPage(result, "theme");
		first();
		
	});

}

function theme_query(){
	var url = "../theme/queryThemes?word="+$("#theme_query_word").val()+"&page=" + ((pager.num-1)*pager.size) + "&size=" + pager.size
	+ "&direction=" + pager.direction + "&property=" + pager.property;
	$.get(url, function(result) {
		var state;
		var button;
		var button_state
		var content = "";
		for (var i = 0; i < result.length; i++) {
			switch(result[i].dataState){
			case 1:state="启用";button="btn-danger";button_state="禁用";break;
			case 0:state="禁用";button="btn-success";button_state="启用";break;
			}
			content += "<tr>" + "<td>" + result[i].id + "</td>" + "<td>" + result[i].word + "</td>"
			+ "<td>" + result[i].pinyin + "</td>" + "<td>" + result[i].searchFrequency
			+ "</td>" + "<td>" + state
			+ "</td>" + "<td>" + result[i].updated + "</td>" +"<td><div style='float: right'><button class='btn btn-default btn-sm' data-toggle='modal' data-target='#theme_myModal1' onclick='h_theme("+result[i].id+
				   ")'>编辑</button>&nbsp;<button class='btn "+button+" btn-sm' onclick='d_theme("+result[i].id+","+result[i].dataState+")'>"+button_state+"</button></div</td>"+ "</tr>";
		}
		console.log(content);
		$("#theme-content").html(content);
	});
}

$("#theme_update_button").click(function() {
	$.ajax({
		type : "get",
		async : false,
		url : "/theme/update?id="+$("#theme_update_id").val()+"&word="+$('#theme_update_word').val()+"&pinyin="+$('#theme_update_pinyin').val()+"&dataState="+$('#theme_update_state').val(),
		success : function(){
			alert("修改成功！");
			theme_query();
		},
		error : function(errorMsg) {
			alert("请求数据失败！");
		}
	});
});

function h_theme(id){   
    $.ajax({
			type : "get",
			async : false,
			url : "/theme/findOne?id="+id,
			dataType : "json",
			success : function(result){
				var update_state;
				switch(result.dataState){
				case 1:update_state="<option value=1>启用</option><option value=0>禁用</option>";break;
				case 0:update_state="<option value=0>禁用</option><option value=1>启用</option>";break;
				}
				var update = "<div class='row'><form class='form-horizontal'><div class='form-group'><label for='theme_update_id' class='col-sm-2 control-label'>ID:</label>"+
				"<div class='col-sm-9'><input type='text' class='form-control' id='theme_update_id' disabled value='"+result.id+"'></div></div>"+
				"<div class='form-group'><label for='theme_update_word' class='col-sm-2 control-label'>元词:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='theme_update_word' value='"+result.word+"'></div></div>"+
			    "<div class='form-group'><label for='theme_update_pinyin' class='col-sm-2 control-label'>拼音:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='theme_update_pinyin' value='"+result.pinyin+"'></div></div>"+
				"<div class='form-group'><label for='theme_update_state' class='col-sm-2 control-label'>状态:</label><div class='col-sm-9'>"+
				"<select class='form-control' id='theme_update_state'>"+update_state+"</select></div></div></form></div>";
				$("#theme_update").replaceWith("<div class='modal-body' id='theme_update'>" + update + "</div>");
	       		
			},
			error : function(errorMsg) {
				alert("请求数据失败！");
			}
		});
 }; 
function d_theme(id,dataState){
	 var url;
	 switch(dataState){
	 	case 1:url="/theme/update?id="+id+"&dataState=0";break;
		case 0:url="/theme/update?id="+id+"&dataState=1";break;
	 }
    $.ajax({
			type : "get",
			async : false,
			url : url,
			success : function(){
				theme_query();
			},
			error : function(errorMsg) {
				alert("请求数据失败！");
			}
		});
 }; 
