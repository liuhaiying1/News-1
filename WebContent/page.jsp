<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" name="referrer" content="never">
<title>article</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/page.css" />
<link
	href='http://cdn.webfont.youziku.com/webfonts/nomal/101157/19892/5961b566f629d802ec6c13cb.css'
	rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/page.js"></script>
<script>
	var account = '${account}';
	var newsID = '${news.ID}';
</script>
</head>

<body>
	<div id="topDiv">
		<font id="logo">时事新闻</font>
	</div>

	<div id="middleDiv">
		<div id="contentDiv">
			<h1>${news.title}</h1>
			<span style="float:right;">${news.date }</span>
			<span style="float:right;">${news.author }&nbsp;&nbsp;&nbsp;</span>
			
			<br>
			<hr />
			<c:forEach items="${news.contentList}" var="contentP">
				${contentP }
			</c:forEach>
		</div>

		<div id="articleDiv">
			<a href="index.do?account_login=${account }"><span style="float:right;">返回首页</span></a>
			<h2>推荐阅读</h2>
			<hr />
			<table>
				<c:forEach items="${recommendList }" var="recommend">
					<tr>
						<a href="showPage.do?newsID=${recommend.ID }"><img src="${recommend.img }"/>
						<br>
						<textarea  readonly="readonly">${recommend.title }</textarea></a>
						<hr/>
					</tr>
				</c:forEach>

			</table>
		</div>

		<div id="commentDiv">

			<textarea id="comment_text" placeholder="发表评论"
				style="overflow: hidden; word-wrap: break-word; height: 64px; width: 99%; resize: none;"></textarea>
			<button id="post_button" onclick="postComment()"
				style="float: right; border: none;">发布</button>
			<br>
			<h3>评论</h3>
			<c:forEach items="${commentList}" var="comment">
				<hr />
				<font class="account">${comment.account }</font>

				<span style="float: right" id="${comment.comment_id }n">&nbsp;&nbsp;${comment.zan }</span>
				<img class="zanPng" id="${comment.comment_id }zan"
					src="images/zan.png"></img>
				<br>
				<br>&nbsp;&nbsp;&nbsp;&nbsp; <font>${comment.content }</font>
				<br>
				<span style="float:left;color:grey">${comment.date }</span>
				<button style="float: right" class="deleteComment"
					id="${comment.comment_id }">删除</button>
				<script>
					mouseOver("${comment.comment_id}", "${comment.account}")
					mouseOver2("${comment.comment_id}");
				</script>
				<br>
			</c:forEach>

		</div>

	</div>

	<div id="bottleDiv"></div>
</body>

</html>