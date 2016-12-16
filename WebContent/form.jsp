<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Form表单</title>
	<script type="text/javascript">
		//表单是否已经提交标识，默认为false
		var isCommitted = false;
		function doSubmit() {
			if(isCommitted == false) {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;
				//返回true，让表单正常提交
				return true;
			} else {
				//返回false，那么表单将不提交
				return false;
			}
		}
		
		function doSubmit2() {
			var btnSubmit = document.getElementById("submit");
			btnSubmit.disabled = "disabled";
			return true;
		}
	
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/DoFormServlet" method="post" onsubmit="return doSubmit2()">
		用户名：
		<input type="text" name="username" />
		<input type="submit" value="提交" id="submit">
	</form>
</body>
</html>