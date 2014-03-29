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
						<div class="panel-body">Welcome in LunchTool <%=user.getName().toString()%>
						<form  class="pull-right" method="POST" action="./Login">
						<input type="hidden" value="logout" name="action"/>
						<input type="submit" class="btn btn-default, pull-right btn btn-info"
							value="Log
								out" />
					</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<%
						Restaurant res = (Restaurant) session.getAttribute("restaurant");
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
							<input type="checkbox" id="dish" name="lunchDish"
								value="<%=menu.get(i).getId()%>">
							<%
								out.println("</li>");
							%>
							<%
								}
							%>
						</ul>
						<input type="hidden" name="action" value="Order">
						<br> <input type="submit" class="btn btn-default"
							value="Order" />
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Your Today's Order</div>
					<form class="navbar-form" method="GET" action="./OrderService">					
					<%
						if (session.getAttribute("orders") != null) {
							out.println("<ul class=\"list-group inputs-list\">");
							List<Order> orders = (List<Order>) session
									.getAttribute("orders");
							for (Order order : orders) {
								out.println("<li class=\"list-group-item\">");
								out.println(order.getDish().getDishName());
								out.println("</li>");
							}
							out.println("</ul>");
						}
					%>
					<input type="hidden" name="action" value="Cancel">
					<br> <input type="submit" class="btn btn-default"
							value="Cancel" />
					</form>
					
				</div>
			</div>
		</div>
</body>

</html>