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
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/validate-employee.js"></script>

</head>

<body>
	<div class="container-fluid">
		<%@include file="component/employee-navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/user-sidebar.jsp"%>

				<div class="container">
					<div class="row" style="margin-top: 3%">
						<h1 style="margin-left: 5%">Update Ticket</h1>
						<hr width="90%" size="1px" align="center" />
					</div>
					<div class="col-lg-3 col-0"></div>
					<div class="col-lg-9 col-12 ">


						<form name="myform" action="<%=request.getContextPath()%>/list-ticket" method="post">
							<!-- Full name -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Customer</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter customer name" maxlength="50" name="name"
												value="${ticket.customerName}" id="customer-name" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Booking time -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Booking time</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="time" class="form-control " name="booking-time"
												value="${ticket.bookingTime}" id="booking-time" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Trip number -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="places"
											class="col-md-4 col-form-label text-md-right justify-content-start"><b>Trip</b>
											<p style="color: red">(*)</p> </label>
										<div class=" col-md-6 ">
											<div class=" input-group ">
												<select class="form-control" name="trip">
													<c:forEach items="${listTrip}" var="trip">
														<c:if test="${trip.tripId == ticket.tripId}">
															<option value="${trip.tripId}" selected="selected">${trip.destination}</option>
														</c:if>
														<c:if test="${trip.tripId != ticket.tripId}">
															<option value="${trip.tripId}">${trip.destination}</option>
														</c:if>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- License plate -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="places"
											class="col-md-4 col-form-label text-md-right justify-content-start"><b>License plate</b>
											<p style="color: red">(*)</p> </label>
										<div class=" col-md-6 ">
											<div class=" input-group ">
												<select class="form-control" name="car">
													<c:forEach items="${listCar}" var="car">
														<c:if test="${car.licensePlate eq ticket.licensePlate}">
															<option value="${car.licensePlate}" selected="selected">${car.licensePlate}</option>
														</c:if>
														<c:if test="${car.licensePlate ne ticket.licensePlate}">
															<option value="${car.licensePlate}">${car.licensePlate}</option>
														</c:if>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" value="update" name="action">
							<input type="hidden" value="${ticket.ticketId}" name="id">
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline mx-4 col-12" style="margin-bottom: 2%">
										<div class="col-lg-3 col-md-3 "></div>
										<div class="col-lg-3 col-md-3 col-12">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<span class="input-group-text"
														style="background-color: orange; border: 1px solid orange"><i
														class="fa fa-undo" aria-hidden="true"
														style="background-color: orange; color: white; border: 1px solid orange"></i></span>
												</div>
												<input type="reset" class="form-control" value="Reset"
													style="background-color: orange; color: white; border: 1px solid orange; padding: 2%">
											</div>
										</div>

										<div class="col-lg-3 col-md-3  col-12">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<span class="input-group-text"
														style="background-color: green; border: 1px solid green"><i
														class="fa fa-plus" aria-hidden="true"
														style="background-color: green; color: white; border: 1px solid green"></i></span>
												</div>
												<input type="submit" class="form-control" value="Update"
													style="background-color: green; color: white; border: 1px solid green; padding: 2%">
											</div>
										</div>
										<div class="col-lg-1"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<html>