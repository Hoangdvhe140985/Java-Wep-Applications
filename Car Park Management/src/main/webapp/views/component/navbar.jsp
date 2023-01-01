<!-- Dashboard -->
<div class="row"
	style="background-color: rgb(248, 249, 249); height: 50px">
	<!-- Employee -->
	<div class="col-lg-2 col-md-3 col-sm-3 col-4  my-3 px-4 ">
		<i class="fa fa-users" href="#" style="color: gray"> Employee</i>
		<div class="clearfix"></div>
	</div>
	<div class="col-lg-5 col-md-1 col-sm-1 col-1 text-md-left"></div>
	<!-- Welcome -->
	<div class="col-lg-2 col-md-3 col-sm-4 col-2 text-md-center my-2 mx-2">
		<p style="color: DodgerBlue;">Welcome: ${account.employeeName}</p>
	</div>
	<!-- Logout -->
	<div class="col-lg-2 col-md-3 col-sm-3 col-3 text-center my-2 mx-2">
		<i class="fa fa-sign-out " aria-hidden="true"
			style="color: DodgerBlue"></i> <a href="<%=request.getContextPath()%>/logout">Logout</a>
	</div>
</div>