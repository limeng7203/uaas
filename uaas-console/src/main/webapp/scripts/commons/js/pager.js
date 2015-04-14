		// 分页对象
		var pager = {
			"size" : 20,
			"num" : 1,
			"nums" : 1,
			"start" : 0,
			"end" : 0,
			"total" : 0,
			"url" : 'basic',
			"direction" : 'ASC',
			"property" : 'id',
		};

		// 计算分页
		function computerPage(total,url) {
			var size = pager.size;
			var nums = total % size == 0 ? total / size : (total + (size - (total % size))) / size;
			pager.nums = nums;
			pager.total = total;
			pager.url = url;
			return pager;
		}

		// 前一页
		function previous() {
			console.log("前一页");
			var size = pager.size;
			var total = pager.total;
			var num = pager.num;
			var nums = pager.nums;
			
			if (num == 1) {
				alert("当前已经是第一页了");
			}
			else{
				num = num - 1;
				pager.num = num;
				pager.start = (num-1) * size;
				var end = num < nums? size : (total % size == 0 ? size: total % size);
				pager.end = end;
				jump();
			}
		}

		// 后一页
		function next() {
			console.log("后一页");
			var size = pager.size;
			var total = pager.total;
			var num = pager.num;
			var nums = pager.nums;
			
			if (num + 1 > nums) {
				alert("当前已经是最后一页了");
			}
			else{
				num = num + 1;
				pager.num = num;
				pager.start = (num-1) * size;
				var end = num < nums? size : (total % size == 0 ? size: total % size);
				pager.end = end;
				jump();
			}
		}

		// 首页
		function first() {
			var size = pager.size;
			var total = pager.total;
			var num = 1;
			var nums = pager.nums;
			var end = total < size ? total : size;
			pager.end = end;
			pager.num = num;
			pager.start = 0;
			jump();
		}

		// 末页
		function end() {
			console.log("末页");
			var size = pager.size;
			var total = pager.total;
			var num = pager.nums;
			var end = total % size == 0 ? size: total % size;
			pager.end = end;
			pager.num = num;
			pager.start = (num-1) * size;
			jump();
		}
			
		// 跳转
		function jump() {
			if(pager.url=="theme"){
				$("#theme_page-info").text("共 " + pager.num + "/ " + pager.nums + " 页");
				theme_query();
			}
			if(pager.url=="document"){
				$("#document_page-info").text("共 " + pager.num + "/ " + pager.nums + " 页");
				document_query();
			}
			if(pager.url=="association"){
				$("#promptThesaurus_page-info").text("共 " + pager.num + "/ " + pager.nums + " 页");
				associationQuery();
			}
		}
		
		function o(property){
			pager.property=property;
			if(pager.direction=="ASC"){
				pager.direction="DESC";
			}else{
				pager.direction="ASC";
			}
			jump();
		}