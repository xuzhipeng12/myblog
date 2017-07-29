<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style>
#bgmusic {
	text-align: right;
}
#back{
	color: #666;
	text-decoration: none;
	font-size: 25px;
	border: 1px solid #555;
	margin-top: 10px;
	margin-left: 3px; 
}
</style>
</head>
<body>
	<a id="back" href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
	<div>
		<div id='bgmusic'>
		<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=404459209&auto=1&height=66"></iframe>
		</div>
		<div style="width: 40%">
			<p>&nbsp;&nbsp;学习、工作要像这个大象一样，可以走得慢，但一定要坚持一直走！</p>
			<p style="text-align: right;">--许志鹏</p>
		</div>
	</div>
	<div id="element">
	<div class="ele-container">
	  <div class="ele-wrapper">
		<div class="ele-tail"></div>
		<div class="ele-body">
		  <div class="ele-head">
			<div class="ele-eyebrows"></div>
			<div class="ele-eyes"></div>
			<div class="ele-mouth"></div>
			<div class="ele-fang-front"></div>
			<div class="ele-fang-back"></div>
			<div class="ele-ear"></div>
		  </div>
		</div>
		<div class="ele-leg-1 ele-leg-back">
		  <div class="ele-foot"></div>
		</div>
		<div class="ele-leg-2 ele-leg-front">
		  <div class="ele-foot"></div>
		</div>
		<div class="ele-leg-3 ele-leg-back">
		  <div class="ele-foot"></div>
		</div>
		<div class="ele-leg-4 ele-leg-front">
		  <div class="ele-foot"></div>
		</div>
	  </div>
	</div>
	</div>

</body>
</html>