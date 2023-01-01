<div class="row" style="height: auto;">
	<div class="col-lg-2 col-12"
		style="width: 200px; background-color: rgb(248, 249, 249)">
		<div class="col-lg-12 py-4">
			<div class="row mb-3">
				<div class="col-lg-12 ">
					<i class="fa fa-tachometer" aria-hidden="true"
						style="color: DodgerBlue; margin: 1px"> Dashboard </i>
				</div>
			</div>

			<div class="dropdown-divider"></div>

			<!-- Employee Management -->
			<div class="row">
				<div class=" col-12 pl-2">

					<button class="btn btn-light dropdown-toggle " type="button"
						data-toggle="collapse" data-target="#collapse1"
						style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
						<i class="fa fa-bar-chart" aria-hidden="true"
							style="color: DodgerBlue"> Employee Management</i>
					</button>

					<div class="collapse form-group" id="collapse1"
						style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
						<div class="dropdown-divider"></div>
						<!-- Employee List -->
						<div>
							<a href="<%=request.getContextPath()%>/list-employee"><i class=" btn btn-link fa fa-list mt-1 ml-4"
								aria-hidden="true" style="color: DodgerBlue;"> Employee List</i></a>
						</div>
						<!-- Add Employee -->
						<div>
							<div class="dropdown-divider"></div>
							<a href="<%=request.getContextPath()%>/add-employee"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
								aria-hidden="true" style="color: DodgerBlue;"> Add Employee</i></a>
						</div>
						<div class="dropdown-divider"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col py-8"></div>
			</div>
			<div class="row">
				<div class="col py-4"></div>
			</div>
		</div>
	</div>