<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" name="referrer" content="never">
<title>video</title>
<link href="css/video.css" rel="stylesheet">
</head>
<body>

	<div id="header">
		<span class="title">头 条 新 闻 视 频</span> <span class="bt"> <a
			href="index.do?account_login=${account }">返回首页</a> <a href="updateVideos.do">更新</a>
		</span>
	</div>
	<hr>
	<div class="mainWrap">
		<div style="width:100%;min-height:800px;margin:30px;">
			<c:forEach items="${videoList }" var="video">
				<div style="width:390px;height:350px;overflow:hidden;display:inline-block;margin:10px">
					<div class="pic" >
						<a href="showVideo.do?videoID=${video.video_id }" target="_blank"> <img
							src="${video.img }">
						</a>
					</div>
					<div class="tit" style="display:inline-block;">${video.title }</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>

