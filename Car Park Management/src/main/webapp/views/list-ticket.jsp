<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>List Ticket</title>
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
			<!-- container List Ticket-->
			<div class="container">
				<div class="col-xl-12 white-text text-center text-md-left ">
					<h1 style="color: black">Ticket List</h1>
					<hr class="hr-light">
				</div>
				<form
					action="<%=request.getContextPath()%>/list-ticket?action=search&indexSearch=1"
					method="post">
					<div class="row">
						<div class="col-lg-4  ">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-search"
										aria-hidden="true"></i></span>
								</div>
								<input type="text" class="form-control" name="search"
									placeholder="Search">
							</div>
						</div>
						<div class="col-lg-3 ">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-filter"
										aria-hidden="true">Filter By</i></span>
								</div>
								<select class="form-control" name="filter">
									<option value="destination" selected>Trip</option>
									<option value="licensePlate" selected>License plate</option>
									<option value="customerName" selected>Customer</option>
								</select>
							</div>
						</div>
						<div class="col-lg-1  ">
							<button type="submit" class="btn " name="Sreach"
								style="background-color: DodgerBlue; color: white">Search</button>
						</div>
						<div class="col-lg-3 ">
							<div class="input-group mb-3">
								<select style="margin-right: 10px" class="form-control"
									name="day">
									<c:forEach begin="1" end="31" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select> <select style="margin-right: 10px" class="form-control"
									name="month">
									<c:forEach begin="1" end="12" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select> <select class="form-control" name="year">
									<c:forEach begin="2010" end="2022" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>
				</form>

				<c:if test="${notification ne null}">
					<div class="alert alert-danger" role="alert">${notification}</div>
				</c:if>
				<c:if test="${notification eq null}">
					<div class="card ">
						<div class="card-body">
							<form>
								<table class="table table-bordered table-striped ">
									<thead style="background-color: rgb(248, 249, 249)">
										<tr>
											<th>ID</th>
											<th>Trip</th>
											<th>License plate</th>
											<th>Customer</th>
											<th>Booking time</th>
											<th colspan="2">Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${listTickets}" var="ticket">
											<tr>
												<td>${ticket.ticketId}</td>
												<td>${ticket.tripName}</td>
												<td>${ticket.licensePlate}</td>
												<td>${ticket.customerName}</td>
												<td>${ticket.bookingTime}</td>
												<td><i class="fas fa-upload" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="<%=request.getContextPath()%>/list-ticket?action=update&ticketId=${ticket.ticketId}"
													title="">Update</a></td>
												<td><i class="fa fa-trash-o" style="color: #007bff"
													aria-hidden="true"></i> <a
													href="#" onclick="checkdelete(${ticket.ticketId})"title="">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${paging != 1}">
								<c:if test="${index > 1}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-ticket?action=listTicket&index=${index - 1}">Previous</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/list-ticket?action=listTicket&index=${index}">${index}</a></li>
								<c:if test="${index < numberOfPage}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-ticket?action=listTicket&index=${index + 1}">Next</a></li>
								</c:if>
							</c:if>
							<c:if test="${paging == 1}">
								<c:if test="${index > 1}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-ticket?action=search&indexSearch=${index - 1}&search=${search}&filter=${filter}&dateStr=${dateStr}">Previous</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="<%=request.getContextPath()%>/list-ticket?action=search&indexSearch=${index}&search=${search}&filter=${filter}&dateStr=${dateStr}">${index}</a></li>
								<c:if test="${index < numberOfPage}">
									<li class="page-item"><a class="page-link"
										href="<%=request.getContextPath()%>/list-ticket?action=search&indexSearch=${index + 1}&search=${search}&filter=${filter}&dateStr=${dateStr}">Next</a></li>
								</c:if>
							</c:if>

						</ul>
					</nav>
				</c:if>
			</div>
		</div>
	</div>
	<script>
		function checkdelete(ticketId) {
			var option = confirm('Do you want delete ?');
			if (option === true) {
				window.location.href = '<%=request.getContextPath()%>/list-ticket?action=delete&ticketId=' + ticketId;
			}
		}
	</script>
</body>

</html>