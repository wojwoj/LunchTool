<%@page import="com.caucho.network.listen.TcpPort.SuspendReaper"%>
<%@page import="com.lunchtool.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="span4 offset2">
				<div class="page-header">
					<h1>Welcome in Lunch Tool</h1>
				</div>
			</div>
			<div class="span8"></div>
		</div>
		<%
			if (request.getSession(false) != null) {
				
				System.out.println(request.getRequestURL());
				User user = (User) session.getAttribute("user");
				System.out.println(user);
				if (user == null && request.getRequestURL().toString().equals("http://localhost:8080/LunchTool/index.jsp")) {
					System.out.println("jest w if");
		%>
		<div class="alert alert-danger">Wrong login or password</div>
		<%
			session.invalidate();
				}
			}
		%>

		<div class="col-md-6">I'm on the left</div>
		<div class="col-md-6">I'm on the right</div>
		<form class="navbar-form navbar-left" method="POST" action="./Login">
			Login:&nbsp;<input class="form-control" type="text" name="login"
				value="" /><br> Hasło:&nbsp;<input class="form-control"
				type="password" name="password" value="" /><br> <input
				type="submit" class="btn btn-default" value="Loguj się" />
		</form>
	</div>
</body>
</html>