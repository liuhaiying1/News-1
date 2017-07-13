function postComment() {
	if ($(comment_text).val() == "")
		return;
	if (account == "") {
		alert("请先登录!");
		return;
	}
	if ($(comment_text).val().length > 200) {
		alert("评论不能超过200字");
		return;
	}

	console.log($(comment_text).val());

	var data = {
		account : account,
		newsID : newsID,
		content : $(comment_text).val()
	}

	$.ajax({
		type : "post",
		dataType : "text",
		url : 'postComment.do',
		data : data,
		success : function(data) {
			alert("发布成功");
			$(comment_text).val("");
			location.reload()
		}
	});
}

function mouseOver(id, account) {
	var id2 = id;
	id = "#" + id;
	$(id).mouseover(function() {
		$(id).css("background-color", "#FA473A");
	});
	$(id).mouseout(function() {
		$(id).css("background-color", "#DDDDDD");
	});
	$(id).click(function() {
		deleteComment(id2, account)
	});
}

function mouseOver2(comment_id) {
	var zanID = "#" + comment_id +"zan";
	var nID = "#" + comment_id+"n";
	var num = parseInt($(nID).html().replace(/&nbsp;/g, ""));

	$(zanID).mouseover(function() {
		if ($(zanID).val() == "")
			$(zanID).css("background-color", "orange");
		
	});

	$(zanID).mouseout(function() {
		if ($(zanID).val() == ""){
			$(zanID).css("background-color", "white");
			
		}
			
	});

	$(zanID).click(function() {
		if ($(zanID).val() == "") {
			$(zanID).css("background-color", "orange");
			$(zanID).val("1");
			console.log("点赞")
			num+=1;
			updateZan(num,comment_id,1);
			$(nID).html("&nbsp;&nbsp;"+num);
			return;
		}
		if($(zanID).val()==1){
			$(zanID).css("background-color", "white");
			$(zanID).val("");
			console.log("取消点赞")
			num-=1;
			updateZan(num,comment_id,0);
			$(nID).html("&nbsp;&nbsp;"+num);
		}
	});
}

function deleteComment(comment_id, account2) {

	if (account != account2) {
		alert("只能删除自己的评论!");
		return;
	}

	var data = {
		comment_id : comment_id
	}
	$.ajax({
		type : "post",
		dataType : "text",
		url : 'deleteComment.do',
		data : data,
		success : function(data) {
			alert("删除成功");
			location.reload()
		}
	});
}

function updateZan(zan, comment_id, signal){
	
	var data={
		zan: zan,
		comment_id: comment_id,
		signal: signal
	}
	
	$.ajax({
		type : "post",
		dataType : "text",
		url : 'updateZan.do',
		data : data,
		success : function(data) {
			console.log("update zan");
		}
	});
}

$(document).ready(function() {
	$(post_button).mouseover(function() {
		$(post_button).css("background-color", "#FA473A");
	});
	$(post_button).mouseout(function() {
		$(post_button).css("background-color", "#DDDDDD");
	});
})

