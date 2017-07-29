<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎注册</title>
</head>
<script>
	function changeCode(){
		var imgs = document.getElementsByTagName("img")[0];
		imgs.src = "servlet/CheckCode?time="+new Date().getTime();
	}
</script>
<style>
div {
	text-align: center;
	padding-top: 10%;
}
</style>
<body>
	<h3>注册</h3>
	<form method="post" action="">
		用户名：<input type="text" name="userName"> <br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
		确认密码：<input type="password" name="password"><br> 验证码：<input
			type="text" name="checkedCode"> <br> <img alt="验证码"
			src="servlet/CheckCode" onclick="changeCode()" /><a
			href="javascript:changeCode()">看不清，换一张</a><br> <input
			type="submit" value="登陆">
	</form>
</body>
</html>