<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Add Car</title>
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

				<!-- container Add -->
				<div class="container">
					<div class="row" style="margin-top: 3%">
						<h1 style="margin-left: 5%">Add Car</h1>
						<hr width="90%" size="1px" align="center" />
					</div>
					<div class="col-lg-3 col-0"></div>
					<div class="col-lg-9 col-12 ">

						<form name="myform" action="<%=request.getContextPath()%>/add-car"
							method="post">

							
							<c:if test="${not empty mess}">
								<div class="alert alert-${alert}" role="alert">${mess}</div>
							</c:if>
							

							<!-- License plate -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>License
												plate</b> <b style="color: red"> (*)</b> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control " maxlength="50"
												name="licensePlate" value="" id="licensePlate" required>
										</div>
									</div>
								</div>
							</div>

							<!-- Car type -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label  justify-content-start "><b>Car
												type</b> </label>
										<div class="col-md-6 col-12 input-group">
											<input type="text" class="form-control " maxlength="50"
												name="carType" value="" id="" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Car color -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label class="col-md-4 col-form-label justify-content-start "><b>Car
												color</b> </label>
										<div class="col-md-6 col-12 input-group">
											<input class="form-control" type="text" maxlength="50"
												name="carColor" value="" id="" required>
										</div>
									</div>
								</div>
							</div>
							<!-- Company -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="places"
											class="col-md-4 col-form-label text-md-right justify-content-start"><b>Company</b>
											<b style="color: red"> (*)</b> </label>
										<div class=" col-md-6 ">
											<div class=" input-group ">
												<select class="form-control" name="company">
													<option value="Phuong Trang" selected>Phuong Trang</option>
													<option value="Cam Van">Cam Van</option>
													<option value="Hoang Long">Hoang Long</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- Parking lot -->
							<div class="form-group ">
								<div class="col-lg-12 bg-white">
									<div class="form-inline">
										<label for="places"
											class="col-md-4 col-form-label text-md-right justify-content-start"><b>Parking
												lot</b> <b style="color: red"> (*)</b> </label>
										<div class=" col-md-6 ">
											<div class=" input-group ">
												<select class="form-control" name="parkId">


													<c:forEach items="${parkinglots}" var="lot">
														<option value="${lot.parkId}">${lot.parkName}</option>
													</c:forEach>

													<%-- 
													<option value="1" selected>Bai so 1</option>
													<option value="2">Bai so 2</option>
													<option value="3">Bai so 3</option>
													--%>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--button -->
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
												<input type="submit" class="form-control" value="Add"
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