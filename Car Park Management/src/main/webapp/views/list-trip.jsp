<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip List</title>
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
</head>
<body>
	<div class="container-fluid">
		<%@include file="component/employee-navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/user-sidebar.jsp"%>
				<div class="container">
					<div class="col-xl-12 white-text text-center text-md-left ">
						<h1 style="color: black">Trip List</h1>
						<hr class="hr-light">
					</div>

					<form action="<%=request.getContextPath()%>/trip?action=searchTrip" method="get">
						<div class="row">
							<div class="col-lg-3  "><input type="hidden" name="action" value="searchTrip"></div>						
							<div class="col-lg-3 ">
								<div class="input-group mb-3">
									<select style="margin-right: 10px" class="form-control" name="day">
										<c:forEach begin="1" end="31" var="i">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
									<select style="margin-right: 10px" class="form-control" name="month">
										<c:forEach begin="1" end="12" var="i">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
									<select class="form-control" name="year">
										<c:forEach begin="2010" end="2022" var="i">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-lg-2  ">
								<button type="submit" class="btn"
									style="background-color: DodgerBlue; color: white">Search</button>
							</div>						
						</div>
					</form>


					<div class="card ">
						<div class="card-body">
							<form>
								<table class="table table-bordered table-striped ">
									<thead style="background-color: rgb(248, 249, 249)">
										<tr>
											<th>No</th>
											<th>Destination</th>
											<th>Departure time</th>
											<th>Driver</th>
											<th>Car type</th>
											<th>Booked ticket number</th>
											<th colspan="3">Action</th>

										</tr>
									</thead>

									<tbody>
										<c:forEach items="${listTrip}" var="trip">
											<tr>
												<td>${trip.tripId}</td>
												<td>${trip.destination}</td>
												<td>${trip.departureTime}</td>
												<td>${trip.driver}</td>
												<td>${trip.carType}</td>
												<td>${trip.bookedTicketNumber}</td>
												<td><i class="fas fa-upload" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/trip?action=update&tripId=${trip.tripId}"
													title="">Update</a></td>
												<td><i class="fa fa-trash-o" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/trip?action=delete&tripId=${trip.tripId}"
													title="">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${index > 1}">
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/trip?action=viewTrips&index=${index - 1}">Previous</a></li>
							</c:if>
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/trip?action=viewTrips&index=${index}">${index}</a></li>
							<c:if test="${index < numberOfPage}">
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/trip?action=viewTrips&index=${index + 1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>