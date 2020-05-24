layui.extend({
	admin: '{/}../../static/js/admin'
});

layui.use(['table', 'jquery','form', 'admin'], function() {
	var table = layui.table,
		$ = layui.jquery,
		form = layui.form,
		admin = layui.admin;
	var data = "";
	$.ajax({
		url: 'http://localhost:8080/api/user/getAllUser',
		type: 'get',
		// 设置的是请求参数
		// data: data.field,
		// 用于设置响应体的类型 注意 跟 data 参数没关系！！！
		dataType: 'json',
		success: function (res) {
			// 一旦设置的 dataType 选项，就不再关心 服务端 响应的 Content-Type 了
			// 客户端会主观认为服务端返回的就是 JSON 格式的字符串
			data=res.data.list;
			// var data="";
			// $('#memberList > tbody').html("");
			// console.log(res.data.list);
			// for (var i = 0;i<res.data.list.length;i++){
			// 	var auth = "";
			// 	if (res.data.list[i]["type"]==0){
			// 		auth = "普通用户";
			// 	}else if(res.data.list[i]["type"]==1){
			// 		auth = "管理员";
			// 	}
			// 	// console.log(res.data.list[i]["name"]);
			// 	data+="<tr data-id='"+res.data.list[i]["id"]+"'><td>" +
			// 		"<div class='layui-unselect layui-form-checkbox'lay-skin='primary'data-id='"+res.data.list[i]["id"]+"'>" +
			// 		"<i class='layui-icon'>&#xe605;</i></div></td><td>"+res.data.list[i]["id"]+"</td><td>"+res.data.list[i]["name"]+"</td>" +
			// 		"<td>"+res.data.list[i]["mobile"]+"</td>" +
			// 		"<td>"+res.data.list[i]["mail"]+"</td>" +
			// 		"<td>"+formatDate(res.data.list[i]["createTime"])+"</td><td>"+formatDate(res.data.list[i]["updateTime"])+"</td>" +
			// 		"<td class='td-status'><span class='layui-btn layui-btn-normal layui-btn-xs'>"+auth+"</span></td>" +
			// 		"<td class='td-manage'>" +
			//
			// 		"<a title='编辑' onclick=\"WeAdminEdit('编辑','edit.html', "+res.data.list[i]["id"]+", 600, 400)\" href=\"javascript:;\"><i class='layui-icon layui-icon-edit'></i></a>" +
			// 		"<a title='删除'onclick=\"member_del(this,"+res.data.list[i]["id"]+")\"href=\"javascript:;\"><i class='layui-icon layui-icon-delete'></i></a></td></tr>";
			//
			// 	$('#memberList > tbody').html(data);
			// 	// console.log("1123123")
			// }

		}
	})
	table.render({
		elem: '#articleList',
		cellMinWidth: 80,
		cols: [
			[{
				type: 'checkbox'
			}, {
				field: 'id',title: 'ID',sort: true
			}, {
				field: 'title',title: '标题',templet: '#usernameTpl'
			}, {
				field: 'date',title: '发布时间',sort: true
			}, {
				field: 'category',title: '分类',sort: true
			}, {
				field: 'sort',title: '排序',sort: true
			}, {
				field: 'recommend',title: '推荐',templet: '#recommendTpl',unresize: true
			}, {
				field: 'top',title: '置顶',templet: '#topTpl',unresize: true
			}, {
				field: 'review',title: '审核',templet: '#reviewTpl',unresize: true
			}, {
				field: 'operate',title: '操作',toolbar: '#operateTpl',unresize: true
			}]
		],
		data: [{
			"id": "1",
			"title": "1",
			"date": "2018-02-03",
			"category": "官方动态",
			"sort": "1",
			"recommend": "checked",
			"top": "checked"
		}, {
			"id": "2",
			"title": "WeAdmin的测试数据一二三四五六七",
			"date": "2018-02-03",
			"category": "新闻资讯",
			"sort": "1",
			"recommend": "",
			"top": "checked"
		}],
		event: true,
		page: true
	});
	/*
	 *数据表格中form表单元素是动态插入,所以需要更新渲染下
	 * http://www.layui.com/doc/modules/form.html#render
	 * */
	$(function(){
		form.render();
	});
	
	var active = {
		getCheckData: function() { //获取选中数据
			var checkStatus = table.checkStatus('articleList'),
				data = checkStatus.data;
			//console.log(data);
			//layer.alert(JSON.stringify(data));
			if(data.length > 0) {
				layer.confirm('确认要删除吗？' + JSON.stringify(data), function(index) {
					layer.msg('删除成功', {
						icon: 1
					});
					//找到所有被选中的，发异步进行删除
					$(".layui-table-body .layui-form-checked").parents('tr').remove();
				});
			} else {
				layer.msg("请先选择需要删除的文章！");
			}

		},
		Recommend: function() {
			var checkStatus = table.checkStatus('articleList'),
				data = checkStatus.data;
			if(data.length > 0) {
				layer.msg("您点击了推荐操作");
				for(var i = 0; i < data.length; i++) {
					console.log("a:" + data[i].recommend);
					data[i].recommend = "checked";
					console.log("aa:" + data[i].recommend);
					form.render();
				}

			} else {
				console.log("b");
				layer.msg("请先选择");
			}

			//$(".layui-table-body .layui-form-checked").parents('tr').children().children('input[name="zzz"]').attr("checked","checked");
		},
		Top: function() {
			layer.msg("您点击了置顶操作");
		},
		Review: function() {
			layer.msg("您点击了审核操作");
		}

	};

	$('.demoTable .layui-btn').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});

	/*用户-删除*/
	window.member_del = function(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发异步删除数据
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon: 1,
				time: 1000
			});
		});
	}

});

function delAll(argument) {
	var data = tableCheck.getData();
	layer.confirm('确认要删除吗？' + data, function(index) {
		//捉到所有被选中的，发异步进行删除
		layer.msg('删除成功', {
			icon: 1
		});
		$(".layui-form-checked").not('.header').parents('tr').remove();
	});
}