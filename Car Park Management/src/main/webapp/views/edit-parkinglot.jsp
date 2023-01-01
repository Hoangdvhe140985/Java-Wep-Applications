<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Edit Parking lot</title>
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
			<%@include file="component/user-sidebar.jsp"%>
			<!-- Parking name -->
			<div class="container">
				<div class="row" style="margin-top: 3%">
					<h1 style="margin-left: 5%">Edit Parking lot</h1>
					<hr width="90%" size="1px" align="center" />
				</div>
				<div class="col-lg-3 col-0"></div>
				<div class="col-lg-9 col-12 ">

					<form name="myform"
						action="<%=request.getContextPath()%>/list-parkinglot"
						method="post">
						<!-- License plate -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline">
									<label class="col-md-4 col-form-label  justify-content-start "><b>Parking
											name</b> </label>
									<div class="col-md-6 col-12 input-group">
										<input type="text" class="form-control " maxlength="50"
											name="parkName" value="${parkinglot.parkName}" id="" required>
									</div>
								</div>
							</div>
						</div>
						<!-- Place -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline">
									<label for="places"
										class="col-md-4 col-form-label text-md-right justify-content-start"><b>Place</b>
									</label>
									<div class=" col-md-6 ">
										<div class=" input-group ">
											<select class="form-control" name="parkPlace">
												<option value="KhuDong" selected>Khu Dong</option>
												<option value="KhuTay">Khu Tay</option>
												<option value="KhuNam">Khu Nam</option>
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Area -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline">
									<label for="phoneNumber"
										class="col-md-4 col-form-label justify-content-start "><b>Area</b>
									</label>
									<div class="col-md-6 col-12 input-group">
										<input class="form-control" type="text" name="parkArea"
											value="${parkinglot.parkArea}" id="area"  onclick="CheckArea()" required>
										<div class="invalid-feedback" id="areaCheck"
											style="display: none;">Please input area with number
											format</div>
									</div>
									<b>(m2)</b>
								</div>
							</div>
						</div>
						<!-- Price -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline">
									<label for="phoneNumber"
										class="col-md-4 col-form-label justify-content-start "><b>Price</b>
									</label>
									<div class="col-md-6 col-12 input-group">
										<input class="form-control" type="text" name="parkPrice"
											value="${parkinglot.parkPrice}" id="price" onclick="CheckPrice()" required>
										<div class="invalid-feedback" id="priceCheck"
											style="display: none;">Please input price with number
											format</div>
									</div>
									<b>(VND)</b>
								</div>
							</div>
						</div>
						<!-- Status -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline">
									<label for="phoneNumber"
										class="col-md-4 col-form-label justify-content-start "><b>Status</b>
									</label>
									<div class="col-md-6 col-12 input-group">
										<input class="form-control" type="text" name="parkStatus"
											value="${parkinglot.parkStatus}" id="" required>
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" value="edit" name="action"> <input
							type="hidden" value="${parkinglot.parkId}" name="id">
						<!--button -->
						<div class="form-group ">
							<div class="col-lg-12 bg-white">
								<div class="form-inline mx-4 col-12" style="margin-bottom: 2%">
									<div class="col-lg-3 col-md-3 "></div>
									<!--Back -->
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
									<!--Reset -->
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
									<!--Add -->
									<div class="col-lg-3 col-md-3  col-12">
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text"
													style="background-color: green; border: 1px solid green"><i
													class="fa fa-plus" aria-hidden="true"
													style="background-color: green; color: white; border: 1px solid green"></i></span>
											</div>
											<input type="submit" class="form-control" value="Edit"
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
	<!--Js addParkinglot -->
	<script>
		function CheckArea() {
			var area = document.getElementById("area").value;
			var ph = /^\d+$/
			if (area.match(ph)) {
				document.getElementById("areaCheck").style.display = "none";
				document.getElementById("area").style.borderColor = "#ced4da";
				return true;
			} else {
				document.getElementById("areaCheck").style.display = "block";
				document.getElementById("area").style.borderColor = "red";
				return false;
			}
		}

		function CheckPrice() {
			var price = document.getElementById("price").value;
			var ph = /^\d+$/
			if (price.match(ph)) {
				document.getElementById("priceCheck").style.display = "none";
				document.getElementById("price").style.borderColor = "#ced4da";
				return true;
			} else {
				document.getElementById("priceCheck").style.display = "block";
				document.getElementById("price").style.borderColor = "red";
				return false;
			}
		}
	</script>
</body>

</html>