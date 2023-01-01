<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Update Trip</title>
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
		<%@include file="component/employee-navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/user-sidebar.jsp"%>

				<div class="container">
					<div class="row" style="margin-top: 3%">
						<h1 style="margin-left: 5%">Update Trip</h1>
						<hr width="90%" size="1px" align="center" />
					</div>
					<div class="col-lg-3 col-0"></div>
					<div class="col-lg-9 col-12 ">


						<form name="myform" action="<%=request.getContextPath()%>/trip" method="post">
							<!-- Booked Ticket Number -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Booked Ticket Number
										</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter destination" maxlength="50"
												name="booked" value="${trip.bookedTicketNumber}" id="destination" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Destination -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Destination
										</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter destination" maxlength="50"
												name="destination" value="${trip.destination}" id="destination" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Departure time -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Departure
												time </b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="time" name="time" value="${trip.departureTime}"
												id="" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Driver -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Driver
										</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter driver" maxlength="50" name="driver"
												value="${trip.driver}" id="driver" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Car type -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Car
												type </b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter car type" maxlength="50" name="carType"
												value="${trip.carType}" id="carType" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Online ticket -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Maximum
												online ticket number </b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="number" class="form-control " placeholder="0"
												maxlength="50" name="ticket" value="${trip.maximumOnlineTicketNumber}" id="carType" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Departure date -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Departure
												date </b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="date" name="date" value="${trip.departureDate}"
												id="" placeholder="dd/mm/yyyy" required>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" value="update" name="action">
							<input type="hidden" value="${trip.tripId}" name="tripId">
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline mx-4 col-12" style="margin-bottom: 2%">
										<div class="col-lg-3 col-md-3 "></div>
										<div class="col-lg-3 col-md-3  col-12">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<span class="input-group-text"
														style="background-color: DodgerBlue; border: 1px solid DodgerBlue"><i
														class="fa fa-backward" aria-hidden="true"
														style="background-color: DodgerBlue; color: white; border: 1px solid DodgerBlue"></i></span>
												</div>
												<input type="button" class="form-control" value="Back"
													onclick="goBack()"
													style="background-color: DodgerBlue; color: white; border: 1px solid DodgerBlue; padding: 2%">
											</div>
										</div>


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