<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>许志鹏的博客-XuzhipengHome</title>
<!-- 主页，用于跳转到显示所有的文章的serverlet -->
<title>InsertTieleHere</title>
<script>
	function forward(){
		location.href = "servlet/listArticles?page=1";
	}
	forward();
</script>
</head>
<body>
	
</body>
</html>