<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Search Parkinglot</title>
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
				<div class="col-xl-12 white-text text-center text-md-left ">
					<h1 style="color: black">Parkinglot Search</h1>
					<hr class="hr-light">
				</div>

				<form action="<%=request.getContextPath()%>/search-parkinglot"
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
									value="${txt}" placeholder="Paking lot Search">
							</div>
						</div>
						<div class="col-lg-3 ">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-filter"
										aria-hidden="true"> Filter By</i></span>
								</div>
								<select class="form-control" name="option">
									<option value="parkName">Name</option>
									<option value="parkPlace" selected>Place</option>
									<option value="parkArea">Area</option>
									<option value="parkPrice">Price</option>
								</select>
							</div>
						</div>
						<div class="col-lg-2  ">
							<button type="submit" class="btn " name="btnSearch"
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
										<th>Parking lot</th>
										<th>Place</th>
										<th>Area</th>
										<th>Price</th>
										<th>Status</th>
										<th colspan="2">Action</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listSearch}" var="parkinglot">
										<tr>
											<td>${parkinglot.parkId}</td>
											<td>${parkinglot.parkName}</td>
											<td>${parkinglot.parkPlace}</td>
											<td>${parkinglot.parkArea}</td>
											<td>${parkinglot.parkPrice}</td>
											<td>${parkinglot.parkStatus}</td>
											<td><i class="fas fa-upload" style="color: #007bff"
												aria-hidden="true"></i> <a
												href="<%=request.getContextPath()%>/list-parkinglot?action=edit&parkinglotId=${parkinglot.parkId}"
												title="">Edit</a></td>
											<td><i class="fa fa-trash-o" style="color: #007bff"
												aria-hidden="true"></i> <a
												href="<%=request.getContextPath()%>/list-parkinglot?action=delete&parkinglotId=${parkinglot.parkId}"
												title="" onclick="checkdelete()">Delete</a></td>
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
								href="<%=request.getContextPath()%>/search-parkinglot?index=${index-1}&option=${option}&txtSearch=${txt}">Previous</a></li>
						</c:if>
						<c:if test="${maxPage >= 1}">
							<c:forEach begin="1" end="${maxPage}" var="i">
								<li class="page-item"><a class="page-link ${i==index?"
									active":""}" href="<%=request.getContextPath()%>/search-parkinglot?index=${i}&option=${option}&txtSearch=${txt}">${i}</a></li>
							</c:forEach>
						</c:if>
						<c:if test="${index < maxPage}">
							<li class="page-item"><a class="page-link"
								href="<%=request.getContextPath()%>/search-parkinglot?index=${index+1}&option=${option}&txtSearch=${txt}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>

</html>