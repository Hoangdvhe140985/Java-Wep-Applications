<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login SRS</title>
<link
	href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/login.css"
	rel="stylesheet" type="text/css"/>
<script src="<%=request.getContextPath()%>/resources/js/login.js"
	type="text/javascript"></script>
</head>

<body>
	<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
		<div class="container">
			<div class="card login-card">
				<div class="row no-gutters">
					<div class="col-md-5">
						<img src="<%=request.getContextPath()%>/resources/images/car2.jpg"
							alt="login" class="login-card-img">
					</div>
					<div class="col-md-7">
						<div class="card-body">
							<div class="brand-wrapper">
								<img src="<%=request.getContextPath()%>/resources/images/logo.svg"
									alt="logo" class="logo">
							</div>
							<p class="login-card-description">Sign into your account</p>

							<form action="<%=request.getContextPath()%>/login"
								method="post">
								<div class="form-group">
									<label for="email" class="sr-only">Email</label> <input
										type="text" name="account" id="email" class="form-control"
										placeholder="Enter your account" required>
								</div>
								<div class="form-group mb-4">
									<label for="password" class="sr-only">Password</label> <input
										type="password" name="password" id="password"
										class="form-control" placeholder="***********" required>
								</div>
								<input name="login" id="login"
									class="btn btn-block login-btn mb-4" type="submit"
									value="Login"> <label
									style="color: red; font-size: 20px">${show}</label>
							</form>
							<nav class="login-card-footer-nav">
								<a href="#!">Terms of use.</a> <a href="#!">Privacy policy</a>
							</nav>
						</div>
					</div>
				</div>
			</div>

		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>

</html>
