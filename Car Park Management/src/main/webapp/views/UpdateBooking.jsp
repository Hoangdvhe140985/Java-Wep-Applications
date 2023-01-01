<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Booking</title>
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
							<h1 style="margin-left: 5%">Update Booking Office</h1>
							<hr width="90%" size="1px" align="center" />
						</div>
						<div class="col-lg-3 col-0"></div>
						<div class="col-lg-9 col-12 ">

							<form
								action="<%=request.getContextPath()%>/actionBookingOfficeController"
								method="POST">
								<!--- office name --->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label
												class="col-md-4 col-form-label  justify-content-start "><b>
													Booking Office Name </b>
												<p style="color: red">(*)</p> </label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control "
													placeholder="Enter Office Name" maxlength="50" name="name"
													value="${booking.officeName}" id="fullname" required>
											</div>
										</div>
									</div>
								</div>

								<!-- Phone Number -->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label
												class="col-md-4 col-form-label  justify-content-start "><b>Phone
													number</b>
												<p style="color: red">(*)</p> </label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control "
													placeholder="Enter Phone number" maxlength="50"
													name="phone" value="${booking.officePhone}"
													id="phoneNumber" onChange="CheckPhone()" required>
												<div class="invalid-feedback" id="PhoneNumberCheck"
													style="display: none;">Phone number invalid!!.Must be
													10 numbers (0...)</div>
											</div>
										</div>
									</div>
								</div>

								<!--- Office Price -->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label
												class="col-md-4 col-form-label  justify-content-start "><b>
													Price </b>
												<p style="color: red">(*)</p> </label>
											<div class="col-md-6 col-12 input-group">
												<input type="text" class="form-control " placeholder="Price"
													maxlength="50" name="price" value="${booking.officePrice}"
													id="fullname" required> <label>(VND)</label>
											</div>
										</div>
									</div>
								</div>

								<!-- Plane -->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="places"
												class="col-md-4 col-form-label text-md-right justify-content-start"><b>Plane</b>
												<p style="color: red">(*)</p> </label>
											<div class=" col-md-6 ">
												<div class=" input-group ">
													<select class="form-control" name="place">
														<jsp:useBean id="db" class="dao.impl.BookingOfficeDAOImpl" />
														<c:forEach items="${db.listPlace}" var="t">
															<option value="${t.officePlace}">${t.officePlace}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="places"
												class="col-md-4 col-form-label text-md-right justify-content-start"><b>Trip</b>
												<p style="color: red">(*)</p> </label>
											<div class=" col-md-6 ">
												<div class=" input-group ">
													<select class="form-control" name="trip">
														<jsp:useBean id="tr" class="dao.impl.TripDAOImpl" />
														<c:forEach items="${tr.trip}" var="p">
															<option value="${p.tripId}">${p.destination}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Date -->
								<div class="form-group ">
									<div class="col-lg-12 bg-white">
										<div class="form-inline">
											<label for="phoneNumber"
												class="col-md-4 col-form-label justify-content-start "><b>Contact
													Deadline</b>
												<p style="color: red">(*)</p> </label>
											<div class="col-md-6 col-12 input-group">
												<span class="input-group-text"><i class=""
													aria-hidden="true"> From date</i></span> <input
													class="form-control" placeholder="dd/mm/yyyy" type="date"
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
													placeholder="dd/mm/yyyy" type="date" name="to"
													value="${booking.endContractDeadline}" id="" required>
											</div>

										</div>
									</div>
								</div>

								<input type="hidden" value="update" name="action"> <input
									type="hidden" value="${booking.officeId}" name="officeId">

								<!--button -->

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
	</div>
</body>
</html>