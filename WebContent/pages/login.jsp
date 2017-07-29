<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎登陆！</title>
<base href=<%=basePath%>>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script>
	function changeCode(){
		var imgs = document.getElementsByTagName("img")[1];
		imgs.src = "servlet/checkcode?time="+new Date().getTime();
	}
</script>
<style type="text/css">
#login {
	padding-top: 60px;
	text-align: center;
}
</style>
<body>
	<%@include file="/pages/topdiv.jsp"%>
	<div id="login">
		<h3>登陆</h3>
		<%
			String userName = "" ; 
			String checked = "";
			Cookie[] ck = request.getCookies();
			for(int i=0; ck!=null && i<ck.length; i++){
				if(ck[i].getName().equals("userName")){
					userName = ck[i].getValue();
					checked = "checked='checked'";
				}
			}
		 %>
		<p style="color: red">
			<c:if test="${msg != null}">提示信息：${msg }</c:if>
		</p>
		<form method="post"
			action="${pageContext.request.contextPath}/servlet/loginservlet">
			用户名：<input type="text" name="userName" value=<%=userName %>>
			<br>
			<br> 密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
			<input type="checkbox" name="remeber" <%=checked %>>记住用户名&nbsp;
			<input type="checkbox" name="autologin" ><span>自动登录</span><br/>
			验证码：<input type="text" name="checkedCode"> <span id="checkmsg"></span><br>
			<br> <img alt="验证码" src="servlet/checkcode"
				onclick="changeCode()" /><a href="javascript:changeCode()">看不清，换一张</a><br>
			<input type="submit" value="登陆">
		</form>
	</div>
</body>
</html>
