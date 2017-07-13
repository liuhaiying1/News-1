/*登录模态框显现*/
function modal_login()
{
	
	$(".modal_login").css({"display":"block","position":"fixed","top":"100px","left":"100px","border":"2px solid red"});	
	
}

/*注册模态框显现*/
function modal_register()
{
	$(".modal_register").css({"display":"block","position":"fixed","top":"100px","left":"100px","border":"2px solid red"});	
}

/*点叉，登录模态框隐藏*/
function modal_login_no()
{
	$(".modal_login").css("display","none");
}

/*点叉，注册模态框隐藏*/
function modal_register_no()
{
	$(".modal_register").css("display","none");
}


function exit()
{
	    $(".login_a").css("display","inline-block");
	    $(".register_a").css("display","inline-block");	
	    $(".welcome").css("display","none");
	    $(".exit_span").css("display","none"); 	    
	    self.location.href="index.do";//跳转
}

function dislike(data1,data2)
{
	if(data2 == ""){
		alert("请先登录");
		return;
	}
    alert("不喜欢这条新闻");
    var data={
        	newsID:data1,
    	    account:data2
    }
    $.ajax({
        type: "post",
        dataType: "text",
        url: './dislike.do',
        data: data,
        success: function (data)
        {
            location.reload();
        }
    });
}

function showdislike(data)
{
	 
	 $("#dislike"+data).css("display","inline-block");
}

function unshowdislike(data)
{
	 $("#dislike"+data).css("display","none");
}


