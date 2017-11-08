<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8" name="referrer" content="never">
    <title>index</title>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
     <script type="text/javascript">
     
     function load()
     {	  
     	  if("${account_login}"!="")
     		 {
     		    $(".login_a").css("display","none");
     	        $(".register_a").css("display","none");
     	        $(".exit_span").css("display","inline-block"); 
     		 }
     }
     </script>
</head>

<body onload="load()">
   <!-- 头部 -->
   <div class="header">
      <img src="images/header2.jpg"/>
   </div>
   
   <!-- 登录，注册，退出 -->
   <div class="sign" >
   <div class="left">    
   <a href="#"  onclick="modal_login()" class="login_a"> <span class="login_span">登录&nbsp;&nbsp;|</span></a>&nbsp;
    <a href="#"  onclick="modal_register()" class="register_a"><span class="register_span">注册</span></a>
    <span class="welcome" style="margin-left: 20px;">${account_login}</span></div>
   <div class="right">
     <span class="update_span" ><a href="updateNews.do">更新新闻</a></span>&nbsp;&nbsp;
     <span class="video_span"><a href="video.do?account=${account_login }">查看视频新闻</a></span>
     <span class="exit_span" onclick="exit()">退出</span>
   </div> 
   </div> 
  
  
   <!-- 主体 -->
       <!--content-->
       <div class="content">
        <div class="content_padding">
          <c:forEach items="${newsList}" var="news">
            <div class="new_div" >
                <div class="new_div_top"  onmouseover="showdislike('${news.ID}')" onmouseout="unshowdislike('${news.ID}')"> 
                   <img src="images/display.gif" id="dislike${news.ID}" class="dislike" onmousedown="dislike(${news.ID},'${account_login}')" />
                   <a href="showPage.do?newsID=${news.ID}&account_login=${account_login}"><img class="a_img" src="${news.img}"  ></a>                 
                </div>
                <div class="newfoot_div">  
                   <a href="showPage.do?newsID=${news.ID}&account_login=${account_login}">
                   <h4>${news.title}</h4><hr/><br/>
                   <span class="preview_span"><img src="images/preview.gif" class="preview_image"> ${news.preview}</span>            
                   </a>
                </div> 	  
            </div>
          </c:forEach> 
        </div>
       </div>
       <!--content end-->

   <!-- 底部 -->
   <div class="footer">
   <div class="foot-content" >
      <img src="images/foot.gif"/>
      <h4 >到底啦！</h4>
   </div>
   </div>
    
       <!-- 登录模态框 -->
    <div class="modal_login" style="display: none;">
     <!-- 登录模态框头部 -->
     <div class="modal_login_head">
           <h4>登录</h4>
     <div class="guanbi" onclick="modal_login_no()"> </div>
     </div>
     <!-- 登录模态框表单 -->
     <form action="login.do" method="post">
	            <ul class="modal-login-bottom">
	                <li>
	                    <span>用户名</span>
	                    <i>*</i>
	                    <input type="text" name="account_login" id="login_account"/>
	                    <div id="login_account_message"></div>
	                </li>
	                <li>
	                    <span>密&nbsp;&nbsp;&nbsp;码</span>
	                    <i>*</i>
	                    <input type="password" name="password_login" id=login_password/>
	                     <div id="login_password_message"></div>
	                </li>
	            </ul>
	             <p>如果您还没有登录账号，请先注册</p>
       <input class="login_submit_input" type="submit" value="submit"/>&nbsp;&nbsp;<input class="login_reset_input" type="reset" value="reset"/>
     </form>
   </div>
   
    <div class="modal_register" style="display: none;">
      <div class="modal_register_head">
          <h4>注册</h4>
          <div class="guanbi" onclick="modal_register_no()"> </div>
            <form action="register.do" method="post">
	            <ul class="modal-login-bottom">
	                <li>
	                    <span>用户名</span>
	                    <i>*</i>
	                    <input type="text" name="account" />
	                </li>
	                <li>
	                    <span>密&nbsp;&nbsp;&nbsp;码</span>
	                    <i>*</i>
	                    <input type="password" name="password"/>
	                </li>
	            </ul>
	             <p>如果您已注册，请直接登陆</p>
	              <input class="register_submit_input" type="submit" value="submit"/>&nbsp;&nbsp;<input class="register_reset_input" type="reset" value="reset"/>
	             </form>
	             
      </div>
      
    </div>
 

</body>


<script src="js/index.js"></script>

</html>