<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Car List</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
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

</head>

<body>
	<div class="container-fluid">
		<%@include file="component/employee-navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/user-sidebar.jsp"%>
				<div class="container">
					<div class="col-xl-12 white-text text-center text-md-left ">
						<h1 style="color: black">Car List</h1>
						<hr class="hr-light">

					</div>
					<form
						action="<%=request.getContextPath()%>/list-car?action=searchCar&indexSearch=1"
						method="post">
						<div class="row">
							<div class="col-md-3  "></div>
							<div class="col-md-4  ">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fa fa-search"
											aria-hidden="true"></i></span>
									</div>
									<input type="text" class="form-control" name="txt" value=""placeholder="Search">
								</div>
							</div>
							<div class="col-md-3 ">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fa fa-filter"
											aria-hidden="true"> Filter By</i></span>
									</div>
									<select class="form-control" name="filter">

										<option value="licensePlate">License Plate</option>
										<option value="carType">Car Type</option>
										<option value="carColor">Car Color</option>
										<option value="company">Company</option>
										<option value="parkName">Park Name</option>

									</select>
								</div>
							</div>


							<div class="col-lg-2  ">
								<button type="submit" class="btn " name="searchCar"
									style="background-color: DodgerBlue; color: white">Search</button>
							</div>

						</div>
					</form>

					<div class="card">
						<div class="card-body">
							<form action="">
								<table class="table table-bordered">
									<thead style="background-color: rgb(248, 249, 249)">
										<tr>
											<th>License plate</th>
											<th>Car type</th>
											<th>Car color</th>
											<th>Company</th>
											<th>Parking lot</th>
											<th colspan="2">Action</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listCars}" var="car">
											<tr>
												<td>${car.licensePlate}</td>
												<td>${car.carType}</td>
												<td>${car.carColor}</td>
												<td>${car.company}</td>
												<td style="color: #007bff;">${car.parkName}</td>
												<td><i class="fas fa-upload" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/list-car?action=update&licensePlate=${car.licensePlate}"
													title="">Edit</a></td>
												<td><i class="fa fa-trash-o" style="color: #007bff"
													aria-hidden="true"></i> <a href="#"
													onclick='showMessCar("${car.licensePlate}")' title="">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>


							</form>
						</div>

					</div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${paging != 1}">
								<c:if test="${index > 1}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-car?action=listCar&index=${index - 1}">Previous</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/list-car?action=listCar&index=${index}">${index}</a></li>
								<c:if test="${index < numberOfPage}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-car?action=listCar&index=${index + 1}">Next</a></li>
								</c:if>
							</c:if>

							<c:if test="${paging == 1}">
								<c:if test="${index > 1}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-car?action=searchCar&indexSearch=${index - 1}&filter=${filter}&txt=${txt}">Previous</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/list-car?action=searchCar&indexSearch=${index}&filter=${filter}&txt=${txt}">${index}</a></li>
								<c:if test="${index < numberOfPage}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-car?action=searchCar&indexSearch=${index + 1}&filter=${filter}&txt=${txt}">Next</a></li>
								</c:if>
							</c:if>

						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<script>
function showMessCar(licensePlate) {
	var option = confirm('Do you want delete ?');
	if (option === true) {
		window.location.href = '<%=request.getContextPath()%>/list-car?action=delete&licensePlate=' + licensePlate;
			}
		}
	</script>

</body>
</html>