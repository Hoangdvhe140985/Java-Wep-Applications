<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Booking</title>
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
</head>
<body>
	<div class="container-fluid">
		<%@include file="component/navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<div class="row" style="height: auto;">
					<%@include file="component/user-sidebar.jsp"%>

					<div class="container">
						<div class="col-xl-12 white-text text-center text-md-left ">
							<h1 style="color: black">Booking Office Search</h1>
							<hr class="hr-light">
						</div>

						<form action="<%=request.getContextPath()%>/searchbooking"
							method="POST">
							<div class="row">
								<div class="col-lg-3  "></div>
								<div class="col-lg-4  ">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-search"
												aria-hidden="true"></i></span>
										</div>
										<input type="text" class="form-control" name="txtSearch"
											value="${txt}">
									</div>
								</div>
								<div class="col-lg-3 ">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-filter"
												aria-hidden="true"> Filter By</i></span>
										</div>
										<select class="form-control" name="option">
											<option value="officeName" selected>Office Name</option>
											<option value="destination" selected>Trip</option>
											<option value="officePlace" selected>Place</option>
										</select>
									</div>
								</div>
								<div class="col-lg-2  ">
									<button type="submit" class="btn " name="btnSearch"
										style="background-color: DodgerBlue; color: white">Search</button>
								</div>

							</div>
						</form>

						<form action="">
							<div class="card ">
								<div class="card-body">

									<table class="table table-bordered table-striped ">
										<thead style="background-color: rgb(248, 249, 249)">
											<tr>
												<th>ID</th>
												<th>Booking Office</th>
												<th>Trip</th>
												<th>Office Place</th>
												<th>Office Price</th>
												<th colspan="3" weight="300px">Action</th>

											</tr>
										</thead>

										<tbody>
											<c:forEach items="${listSearch}" var="booking">
												<tr>
													<td>${booking.officeId}</td>
													<td>${booking.officeName}</td>
													<td>${booking.trip.destination}</td>
													<td>${booking.officePlace}</td>
													<td>${booking.officePrice}</td>


													<td><i class="fas fa-eye" style="color: #007bff"
														aria-hidden="true"></i> <a
														href="<%=request.getContextPath()%>/actionBookingOfficeController?action=view&officeId=${booking.officeId}"
														title="">View</a></td>
													<td><i class="fa fa-trash-o" style="color: #007bff"
														aria-hidden="true"></i> <a
														href="<%=request.getContextPath()%>/actionBookingOfficeController?action=update&officeId=${booking.officeId}"
														title="">Update</a></td>
													<td><i class="fa fa-trash-o" style="color: #007bff"
														aria-hidden="true"></i> <a
														href="<%=request.getContextPath()%>/actionBookingOfficeController?action=delete&officeId=${booking.officeId}"
														title="">Delete</a></td>
												</tr>
											</c:forEach>
										</tbody>

									</table>

								</div>

							</div>
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:if test="${index > 1}">
										<li class="page-item"><a class="page-link"
											href="searchbooking?index=${index-1}&option=${option}&txtSearch=${txt}">Previous</a></li>
									</c:if>

									<c:if test="${maxPage >= 1}">
										<!--page start 1 end = max page dat bien is i -->
										<c:forEach begin="1" end="${maxPage}" var="i">
											<li class="page-item"><a class="page-link ${i==index?"
												active":""}"
                                                href="searchbooking?index=${i}&option=${option}&txtSearch=${txt}">${i}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${index < maxPage}">
										<li class="page-item"><a class="page-link"
											href="searchbooking?index=${index+1}&option=${option}&txtSearch=${txt}">Next</a></li>
									</c:if>
								</ul>
							</nav>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>