<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/ErrorPage/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试page指令的errorPage属性</title>
</head>
<body>
	<%
		//这行代码可定会出错，因为除数是0，一运行就会抛出异常
		int x = 1 / 0;
	%>
</body>
</html>