<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>许志鹏的博客-XuzhipengHome</title>
<meta http-equiv="keywords" content="许志鹏,rabbithouse,xuzhipeng">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/contentstyle.css">
<style type="text/css">
</style>
</head>
<body>
	<!-- top div -->
	<%@include file="/pages/topdiv.jsp"%>
	<!--中间文章区域div-->
	<div id="center_all">
	<%@include file="/pages/centerleft.jsp" %>
	<div id="center"  style="margin-left: 30%">
		<!-- 中间文章区域 -->
		<div id="center-center" >
			<table><tr><td>
			<table>
			<tr><td>
			<c:if test="${not empty article }">
				<div style="text-align: center;">
				<h2>${article.blogHead }</h2>
				<span>作者：${article.blogAuthor }</span>&nbsp;&nbsp;
				<span>编写日期:${article.writeDate }</span>
				</div>
				<br/>
				<div>${article.blogContent}</div>
			</c:if>
			</td></tr>
			</table >
			</td></tr>
			<tr><td>
			<span style="font-size: 20px; margin-top: 20px;">留言板：</span><br/>
			<table  style="width:100%; color: #111;">
				<c:if test="${not empty leaveSay }">
					<c:forEach items="${leaveSay}" var="ls">
					<tr><td style="border: 2px solid #999;border-style: solid none solid none;">
						<br/>
						<span>${ls.whoLeave}</span>:
						<p>${ls.message}</p>
						<span>留言时间：${ls.leaveDate}</span>
					</td></tr>
				</c:forEach>
			</c:if>
			</table>
			</td></tr>
			</table>
		</div>
		<!-- 右侧待定 -->
		<div id="center-right"></div>
		<!-- 底部留言区 -->
		
		<form action="${pageContext.request.contextPath }/servlet/addLeaveSay?id=${article.artId}" method="post">
			<!-- 留言框  -->
			<div margin-top: 40px;">
			<div >
				<span>欢迎留言：</span><br>
				<span>告诉我你的名字嘛(〃'▽'〃):</span><input type="text" name="whoLeave" value="某同学"><br/>
				<textarea name="leaveSays" rows="5" cols="80">
				</textarea>
			</div>
			<div>
				<input type="submit" value="提交留言" />
			</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>