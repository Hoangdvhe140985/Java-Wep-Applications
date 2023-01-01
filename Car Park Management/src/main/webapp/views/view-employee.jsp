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
		<%@include file="component/navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/admin-sidebar.jsp"%>

				<div class="container">
					<div class="row" style="margin-top: 3%">
						<h1 style="margin-left: 5%">View Employee</h1>
						<hr width="90%" size="1px" align="center" />
					</div>
					<div class="col-lg-3 col-0"></div>
					<div class="col-lg-9 col-12 ">


						<form name="myform">
							<!-- Full name -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Full
												name</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control " maxlength="50" name="Name"
												value="${employee.employeeName}" id="fullname" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Phone number -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Phone
												number</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control " maxlength="50" name="Phone"
												value="${employee.employeePhone}" id="phoneNumber" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Date of birth -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Date
												of birth</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="date" name="Date" value="${employee.employeeBirthDate}"
												id="" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Sex -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Sex</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
										<c:if test="${employee.sex == 1}">
											<input type="radio" name="sex" value="Male" style="margin: 2%" checked readonly> 
											<label for="male" style="margin: 1%"> Male</label> 
											<input type="radio" name="sex" value="Female" style="margin: 2%" readonly>
											<label for="female" style="margin: 1%"> Female</label>
										</c:if>
										<c:if test="${employee.sex == 0}">
											<input type="radio" name="sex" value="Male" style="margin: 2%"  readonly> 
											<label for="male" style="margin: 1%"> Male</label> 
											<input type="radio" name="sex" value="Female" style="margin: 2%" checked readonly>
											<label for="female" style="margin: 1%" > Female</label>
										</c:if>
										</div>
									</div>
								</div>
							</div>
							<!-- Address -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Address</b>
										</label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="text" name="Address"
												value="${employee.employeeAddress}" id="Address" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Email -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Email</b>
										</label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="email" name="Email"
												value="${employee.employeeEmail}" id="Email" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Account -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Account</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="text" name="Account"
												value="${employee.account}" id="Account"readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Department -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="places"
											class="col-md-4 col-form-label text-md-right justify-content-start"><b>Department</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="text" name="Department"
												value="${employee.department}" id="Department" readonly>
										</div>
									</div>
								</div>
							</div>

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