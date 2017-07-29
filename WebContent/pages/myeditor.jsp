<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.all.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
<title>写博客</title>
<script>
	var change = function(){
		var oneclass = document.getElementById("oneLeveClass");
		var twoclass = document.getElementById("twoLeveClass");
		
	}
</script>
</head>
<body>
	<!-- 文章标题、分类等信息区域 -->
	<div id="context">
		<form action="${pageContext.request.contextPath }/servlet/addBlog"
			method="post">
			<div id="contextInfo">
				<span>文章标题：</span> <input type="text" name="contextHead"> <span>请选择文章分类：</span>
				<select name="contextTotalType" onchange="change();">
					<option>技术</option>
					<option>生活</option>
				</select>
				<select name="oneLevelClass" id="oneLeveClass" onchange="change();">
					<c:forEach items="${oneLevelClass}" var="oc">
						<option value="${oc.oneLevelClass}">${oc.oneLevelClass}</option>
					</c:forEach>
				</select>
				<select name="twoLevelClass" id="twoLevelClass">
					<c:forEach items="${twoLevelClass}" var="tc">
						<option>${tc.twoLevelClass}</option>
					</c:forEach>
				</select>
			</div>
			<!-- 文章编辑区域  -->
			<div >
				<span>文章概要：</span><br>
				<textarea name="abstruct" rows="3" cols="50">
				</textarea>
			</div>
			<div>
				<p>
					<textarea id="myckeditor" name="myckeditor"></textarea>
				</p>
				<p>
					<input type="submit" value="提交" />
				</p>
			</div>
		</form>
		<p>
			<button onclick="getLocalData()">获取草稿箱内容</button>
			<button onclick="clearLocalDate()">清除草稿箱内容</button>
		</p>
	</div>
	<script>
		<!-- 实例化编辑器 -->
		var ue = UE.getEditor('myckeditor');
		function getLocalData(){
			//alert(ue.exeCommand("getlocaldata"));
			alert(UE.getEditor('myckeditor').execCommand( "getlocaldata" ));
		}
		function clearLocalDate(){
			UE.getEditor('myckeditor').execCommand( "clearlocaldata" );
			alert("已清除草稿箱");
		}
	</script>
</body>

</html>
