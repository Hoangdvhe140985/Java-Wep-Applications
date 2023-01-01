<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>View Employee</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/validate-employee.js"></script>

</head>

<body>
	<div class="container-fluid">
		<c:if test="${account.role == 1}">
			<%@include file="component/navbar.jsp"%>
			<div class="row ">
				<div class="col py-12 ">
					<%@include file="component/admin-sidebar.jsp"%>
		</c:if>
		<c:if test="${account.role != 1}">
			<%@include file="component/employee-navbar.jsp"%>
			<div class="row ">
				<div class="col py-12 ">
					<%@include file="component/user-sidebar.jsp"%>
		</c:if>


		<div class="container">
			<div class="alert alert-danger mt-5" role="alert"><p>${error}</p></div>
		</div>
	</div>
	</div>
	</div>
	</div>

</body>
<html>