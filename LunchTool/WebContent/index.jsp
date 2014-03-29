<%@page import="com.caucho.network.listen.TcpPort.SuspendReaper"%>
<%@page import="com.lunchtool.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<title>LunchTool</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="page-header">
					<h1>Welcome in Lunch Tool</h1>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="panel-heading">
							<div class="panel panel-default">
								<div class="panel-body">
									<form class="navbar-form navbar-left" method="POST"
										action="./Login">
										<div class="input-group">
											<span class="input-group-addon">Login</span> <input
												class="form-control" type="text" name="login" value=""
												placeholder="Login" /><br>
										</div>
										<div class="input-group">
											<span class="input-group-addon">Password</span> <input
												class="form-control" type="password" name="password"
												value="" placeholder="Password" />
										</div>
										<br> <input type="submit" class="btn btn-default"
											value="Login" />
									</form>
								</div>
							</div>
							<%
								if (session.getAttribute("user") == null) {
									if (session.getAttribute("message") != null) {
										if (((String) session.getAttribute("message"))
												.equals("Wrong login or password")) {
							%>
							<div class="alert alert-danger"><%=session.getAttribute("message")%></div>
							<%
								session.invalidate();
										}
									}
								}
							%>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel-heading">
							<div class="panel panel-default">
								<div class="panel-heading">Do not have account yet ?</div>
								<div class="panel-body">
									<form class="navbar-form navbar-left" method="GET"
										action="./RegistrationService">
										<div class="input-group">
											<span class="input-group-addon">Login</span> <input
												class="form-control" type="text" name="login" value=""
												placeholder="Login" /><br>
										</div>
										<div class="input-group">
											<span class="input-group-addon">Name</span> <input
												class="form-control" type="text" name="name" value=""
												placeholder="Name" /><br>
										</div>
										<div class="input-group">
											<span class="input-group-addon">Surname</span> <input
												class="form-control" type="text" name="surname" value=""
												placeholder="Surname" /><br>
										</div>
										<div class="input-group">
											<span class="input-group-addon">Password</span> <input
												class="form-control" type="password" name="password"
												value="" placeholder="Password" />
										</div>
										<input type="hidden" name="action" value="Register"> <br>
										<input type="submit" class="btn btn-default" value="Register" />
									</form>
									<%
										if (session.getAttribute("user") == null) {
											if (session.getAttribute("message") != null) {
												if (((String) session.getAttribute("message"))
														.equals("Registration OK")) {
									%>
								</div>
							</div>
						</div>
						<div class="alert alert-success"><%=session.getAttribute("message")%></div>
						<%
							session.invalidate();

									}
								}
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>