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
		<%@include file="component/navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/admin-sidebar.jsp"%>

				<div class="container">
					<div class="row" style="margin-top: 3%">
						<h1 style="margin-left: 5%">Update Employee</h1>
						<hr width="90%" size="1px" align="center" />
					</div>
					<div class="col-lg-3 col-0"></div>
					<div class="col-lg-9 col-12 ">


						<form name="myform" action="<%=request.getContextPath()%>/list-employee" method="post">
							<!-- Full name -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Full
												name</b>
											<p style="color: red">(*)</p> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control "
												placeholder="Enter full name" maxlength="50" name="Name"
												value="${employee.employeeName}" id="fullname" required>
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
											<input type="text" class="form-control "
												placeholder="Enter Phone number" maxlength="50" name="Phone"
												value="${employee.employeePhone}" id="phoneNumber" onChange="CheckPhone()" required>
											<div class="invalid-feedback" id="PhoneNumberCheck"
												style="display: none;">Phone number invalid!!.Must be
												10 numbers (0...)</div>
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
												id="" placeholder="dd/mm/yyyy" required>
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
											<input type="radio" name="sex" value="1" style="margin: 2%" checked> 
											<label for="male" style="margin: 1%"> Male</label> 
											<input type="radio" name="sex" value="0" style="margin: 2%">
											<label for="female" style="margin: 1%"> Female</label>
										</c:if>
										<c:if test="${employee.sex == 0}">
											<input type="radio" name="sex" value="1" style="margin: 2%" > 
											<label for="male" style="margin: 1%"> Male</label> 
											<input type="radio" name="sex" value="0" style="margin: 2%" checked>
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
												value="${employee.employeeAddress}" id="Address" placeholder="Enter address">
											<div class="invalid-feedback" id="AddressCheck"
												style="display: none;">Address invalid!!</div>
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
												value="${employee.employeeEmail}" id="Email" placeholder="Enter email"
												onChange="ValidateEmail()">
											<div class="invalid-feedback" id="EmailCheck"
												style="display: none;">You have entered an invalid
												email address!</div>
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
												value="${employee.account}" id="Account" placeholder="Enter Account" readonly>
										</div>
									</div>
								</div>
							</div>
							<!-- Password -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="phoneNumber"
											class="col-md-4 col-form-label justify-content-start "><b>Password</b>
											<p style="color: red">(*)</p> </label>

										<div class="col-md-6 col-12 input-group">
											<!-- disabled="disabled" -->
											<input class="form-control" type="password" name="Password"
												value="${employee.password}" id="Password" placeholder="Enter Password"
												onChange="CheckPassword()" required>

											<!-- <div class="input-group-append">
                                                    <button class="btn btn-outline-secondary" type="button"
                                                        id="btnPassword">
                                                        <span class="fas fa-eye"></span>
                                                    </button>
                                                </div> -->

											<div class="invalid-feedback" id="PasswordCheck"
												style="display: none;">Invalid Password !!. 7-14
												letters and numbers, with capital letters.</div>
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
										<div class=" col-md-6 ">
											<div class=" input-group ">
												<select class="form-control" name="Department">
													<option value="Employee" selected>Employee</option>
													<option value="Booking">Booking</option>
													<option value="Service">Service</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" value="update" name="action">
							<input type="hidden" value="${employee.employeeId}" name="id">
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