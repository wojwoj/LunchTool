<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ page import="com.lunchtool.*"%>
	<%@ page import="java.util.*"%>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<div class="panel panel-primary">
						<div class="panel-body"><%=user.getName().toString()%>
							<button type="button" class="pull-right btn btn-info">Log
								out</button>
						</div>
					</div>
					<h1>
						Welcome in order form
						<%=user.getName().toString()%>

					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<%
						Restaurant res = (Restaurant) request.getAttribute("restaurant");
						List<LunchDish> menu = res.getMenu().getMenu();
					%>
					<div class="panel-heading">
						Restaurant
						<%=res.getName()%>
						Menu
					</div>
					<form class="navbar-form" method="GET" action="./OrderService">
						<ul class="list-group inputs-list">
							<%
								for (int i = 0; i < menu.size(); i++) {
									out.println("<li class=\"list-group-item\"> <span class=\"badge\">");
							%>
							<%=menu.get(i).getPrice()%>
							<%
								out.println("</span>");
							%>
							<%=menu.get(i).getDishName()%>
							<input type="checkbox" id="dish" name="lunchDish" value="<%=menu.get(i).getId()%>">
							<%
								out.println("</li>");
							%>
							<%
								}
							%>
						</ul>
						<br> <input type="submit" class="btn btn-default"
							value="Order" />
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Your Order</div>
					<ul class="list-group inputs-list">
						<li class=\"list-group-item\">aadas</li>
					</ul>
				</div>
			</div>
		</div>
</body>

</html>