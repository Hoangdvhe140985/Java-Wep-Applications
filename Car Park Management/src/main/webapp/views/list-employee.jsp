<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Employee List</title>
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
		<%@include file="component/navbar.jsp"%>
		<div class="row ">
			<div class="col py-12 ">
				<%@include file="component/admin-sidebar.jsp"%>
				<div class="container">
					<div class="col-xl-12 white-text text-center text-md-left ">
						<h1 style="color: black">Employee List</h1>
						<hr class="hr-light">
					</div>

					<form action="<%=request.getContextPath()%>/searchEmployee">
							<div class="row">
								<div class="col-lg-3  "></div>
								<div class="col-lg-4  ">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-search"
												aria-hidden="true"></i></span>
										</div>
										<input type="text" placeholder="Search" class="form-control"
											name="txtSearch" value="${txt}">
									</div>
								</div>
								<div class="col-lg-3 ">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-filter"
												aria-hidden="true"> Filter By</i></span>
										</div>
										<select class="form-control" name="option">
											<option value="employeeName">Name</option>
											<option value="department">Department</option>
											<option value="employeeAddress">Address</option>
											<option value="employeePhone">Phone</option>
										</select>
									</div>
								</div>
								<div class="col-lg-2  ">
									<button type="submit" class="btn " name="btnSearch"
										value="search"
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
											<th>ID</th>
											<th>Name</th>
											<th>Date of birth</th>
											<th>Address</th>
											<th>Phone Number</th>
											<th>Department</th>
											<th colspan="3">Action</th>

										</tr>
									</thead>

									<tbody>
										<c:forEach items="${listEmployee}" var="employee">
											<tr>
												<td>${employee.employeeId}</td>
												<td>${employee.employeeName}</td>
												<td>${employee.employeeBirthDate}</td>
												<td>${employee.employeeAddress}</td>
												<td>${employee.employeePhone}</td>
												<td>${employee.department}</td>
												<td><i class="fas fa-eye" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/list-employee?action=view&employeeId=${employee.employeeId}"
													title="">View</a></td>
												<td><i class="fas fa-upload" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/list-employee?action=update&employeeId=${employee.employeeId}"
													title="">Update</a></td>
												<td><i class="fa fa-trash-o" style="color: #007bff"
													aria-hidden="true"></i> <a href="#"
													onclick="showMess(${employee.employeeId})" title="">Delete</a></td>
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
									href="<%=request.getContextPath()%>/list-employee?action=viewEmployees&index=${index - 1}">Previous</a></li>
							</c:if>
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/list-employee?action=viewEmployees&index=${index}">${index}</a></li>
							<c:if test="${index < numberOfPage}">
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/list-employee?action=viewEmployees&index=${index + 1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
function showMess(employeeId) {
	var option = confirm('Do you want delete ?');
	if (option === true) {
		window.location.href = '<%=request.getContextPath()%>/list-employee?action=delete&employeeId=' + employeeId;
	}
}
</script>
<html>