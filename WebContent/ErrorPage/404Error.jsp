<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>404错误友好提示页面</title>
	<!-- 3秒后自动跳转回首页 -->
	<meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath }/index.jsp">
</head>
<body>
	<img alt="对不起，您要访问的页面没有找到，请联系管理员处理！"
		src="${pageContext.request.contextPath }/img/404.png" /><br/>
	3秒后自动跳转会首页，如果没有跳转，请点击<a href="${pageContext.request.contextPath }/index.jsp">这里</a>
</body>
</html>