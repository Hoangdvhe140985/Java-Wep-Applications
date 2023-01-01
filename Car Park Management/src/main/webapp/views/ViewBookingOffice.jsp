<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Booking</title>
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

					<!-- container Add -->
					<div class="container">
						<div class="row" style="margin-top: 3%">
							<h1 style="margin-left: 5%">View Booking Office</h1>
							<hr width="90%" size="1px" align="center" />
						</div>
						<div class="col-lg-3 col-0"></div>
						<div class="col-lg-9 col-12 ">

							<form>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label
												class="col-md-4 col-form-label  justify-content-start "><b>
													Booking Office Name </b> </label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control " maxlength="50"
													name="name" value="${booking.officeName}" id="" required>
											</div>
										</div>
									</div>
								</div>
								<!-- Car type -->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label
												class="col-md-4 col-form-label  justify-content-start "><b>Phone
													Number</b> </label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control " maxlength="50"
													name="phone" value="${booking.officePhone}" id="" required>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="phoneNumber"
												class="col-md-4 col-form-label justify-content-start "><b>Price</b>
											</label>
											<div class="col-md-6 col-12 input-group">
												<input class="form-control" type="text" name="price"
													value="${booking.officePrice}" id="" required>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="places"
												class="col-md-4 col-form-label text-md-right justify-content-start"><b>Place</b>
											</label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control " maxlength="50"
													name="place" value="${booking.officePlace}" id="" required>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="places"
												class="col-md-4 col-form-label text-md-right justify-content-start"><b>Trip</b>
											</label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control " maxlength="50"
													name="trip" value="${booking.trip.destination}" id=""
													required>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="phoneNumber"
												class="col-md-4 col-form-label justify-content-start "><b>Contact
													Deadline</b> </label>
											<div class="col-md-6 col-12 input-group">
												<span class="input-group-text"><i class=""
													aria-hidden="true"> From date</i></span> <input
													class="form-control" placeholder="dd/mm/yyyy" type="text"
													name="from" value="${booking.startContractDealine}" id=""
													required>

											</div>

										</div>
									</div>
								</div>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="phoneNumber"
												class="col-md-4 col-form-label justify-content-start ">
											</label>
											<div class="col-md-6 col-12 input-group">
												<span class="input-group-text"><i class=""
													aria-hidden="true"> To date</i></span> <input class="form-control"
													placeholder="dd/mm/yyyy" type="text" name="to"
													value="${booking.endContractDeadline}" id="" required>
											</div>

										</div>
									</div>
								</div>
								<!--button -->

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline mx-4 col-12" style="margin-bottom: 2%">
											<div class="col-lg-3 col-md-3  col-12"></div>
											<div class="col-lg-3 col-md-3  col-12"></div>
											<div class="col-lg-3 col-md-3  col-12">
												<div class="input-group mb-3">
													<div class="input-group-prepend">
														<span class="input-group-text"
															style="background-color: DodgerBlue; border: 1px solid DodgerBlue"><i
															class="fa fa-backward" aria-hidden="true"
															style="background-color: DodgerBlue; color: white; border: 1px solid DodgerBlue"></i></span>
													</div>
													<input type="button" class="form-control" value="Back"
														onclick="history.back()"
														style="background-color: DodgerBlue; color: white; border: 1px solid DodgerBlue; padding: 2%">

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
	</div>
</body>
</html>