<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>pageContext访问其他域</title>
</head>
<body>
	<%
		//此时相当于往session对象中存放一个name属性，等价于session.setAttribute("name","挨踢爬虫");
		pageContext.setAttribute("name", "挨踢爬虫", PageContext.SESSION_SCOPE);
	%>
	
	<%
		//取得session对象的属性，使用pageContext对象获取
		String refName1 = (String)pageContext.getAttribute("name", PageContext.SESSION_SCOPE);
		//由于取得的值为Object类型，因此必须使用String强制向下转型
		String refName2 = (String)session.getAttribute("name");
	%>	
	<h1>取出存放在session对象中的属性值：</h1>
	<p>第一种做法：使用pageContext.getAttribute("attributeName",PageContext.SESSION_SCOPE);去取出session对象中值</p>
	<h3>姓名：<%=refName1%></h3>
	<p>第二种做法：使用session.getAttribute("attributeName");去取出session对象中值</p>
	<h3>姓名：<%=refName2%></h3>
</body>
</html>