<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/video.css" rel="stylesheet">

<title>play</title>
</head>
<body>
	<div class="wrap">
		<div id="head">
			<span class="title_p">Video</span>
		</div>

		<div id="play1" class="pstyle" >
			<video
				src="https://www.yymeier.com/api.php?url=${video }"
				controls="controls" poster="images/bg.jpg" style="width:100%;"></video>
		</div>

	</div>

</body>
</html>