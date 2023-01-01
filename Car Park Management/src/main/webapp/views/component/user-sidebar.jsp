 <div class="col py-12 ">
                <!-- Dashboard -->
                <div class="row" style="height: auto; ">
                    <div class="col-lg-2 col-12" style="width:200px; background-color: rgb(248, 249, 249)">
                        <div class="col-lg-12 py-4">
                            <div class="row mb-3">
                                <div class="col-lg-12 ">
                                    <i class="fa fa-tachometer" aria-hidden="true"
                                        style="color: DodgerBlue; margin: 1px"> Car park manager </i>
                                </div>
                            </div>

                            <div class="dropdown-divider"></div>

                            <!-- Car manager -->
                            <div class="row">
                                <div class=" col-12 pl-2">

                                    <button class="btn btn-light dropdown-toggle " type="button" data-toggle="collapse"
                                        data-target="#collapse1"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <i class="fa fa-car" aria-hidden="true" style="color: DodgerBlue">
                                            Car manager</i>
                                    </button>

                                    <div class="collapse form-group" id="collapse1"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <div class="dropdown-divider"></div>
                                        <!-- Car List -->
                                        <div>
                                            <a href="<%=request.getContextPath()%>/list-car"><i class=" btn btn-link fa fa-list mt-1 ml-4" aria-hidden="true"
                                                    style="color: DodgerBlue;"> Car
                                                    list</i></a>
                                        </div>
                                        <!-- Add Car -->
                                        <div>
                                            <div class="dropdown-divider"></div>
                                            <a href="<%=request.getContextPath()%>/add-car"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
                                                    aria-hidden="true" style="color: DodgerBlue;"> Add
                                                    Car</i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="dropdown-divider"></div>
                            <div class="row">
                                <!--Booking office manager-->
                                <!-- Car management -->
                                <div class=" col-12 pl-2">
                                    <button class="btn btn-light dropdown-toggle " type="button" data-toggle="collapse"
                                        data-target="#collapse2"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <i class="fa fa-cart-plus" aria-hidden="true" style="color: DodgerBlue">
                                            Booking office manager</i>
                                    </button>

                                    <div class="collapse form-group" id="collapse2"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <div class="dropdown-divider"></div>
                                        <!-- Booking office -->
                                        <div>
                                            <a href="<%=request.getContextPath()%>/listBookingOffice"><i class=" btn btn-link fa fa-list mt-1 ml-4" aria-hidden="true"
                                                    style="color: DodgerBlue;"> Booking office
                                                    list</i></a>
                                        </div>
                                        <!-- Booking office -->
                                        <div>
                                            <div class="dropdown-divider"></div>
                                            <a href="<%=request.getContextPath()%>/addBooking"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
                                                    aria-hidden="true" style="color: DodgerBlue;"> Add
                                                    Booking office</i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="dropdown-divider"></div>
                            <!-- Parking lot management -->
                            <div class="row">
                                <div class=" col-12 pl-2">
                                    <button class="btn btn-light dropdown-toggle " type="button" data-toggle="collapse"
                                        data-target="#collapse3"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <i class="fa fa-map-marker" aria-hidden="true" style="color: DodgerBlue">
                                            Parking lot manager</i>
                                    </button>

                                    <div class="collapse form-group" id="collapse3"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <div class="dropdown-divider"></div>
                                        <!-- Parking lot list -->
                                        <div>
                                            <a href="<%=request.getContextPath()%>/list-parkinglot"><i class=" btn btn-link fa fa-list mt-1 ml-4" aria-hidden="true"
                                                    style="color: DodgerBlue;"> Parking lot
                                                    list</i></a>
                                        </div>
                                        <!-- Add Parking lot -->
                                        <div>
                                            <div class="dropdown-divider"></div>
                                            <a href="<%=request.getContextPath()%>/add-parkinglot"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
                                                    aria-hidden="true" style="color: DodgerBlue;"> Add
                                                    Parking lot</i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="dropdown-divider"></div>
                            <!-- Trip manager -->
                            <div class="row">
                                <div class=" col-12 pl-2">
                                    <button class="btn btn-light dropdown-toggle " type="button" data-toggle="collapse"
                                        data-target="#collapse4"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <i class="fa fa-plane" aria-hidden="true" style="color: DodgerBlue">
                                            Trip manager</i>
                                    </button>

                                    <div class="collapse form-group" id="collapse4"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <div class="dropdown-divider"></div>
                                        <!-- Trip List -->
                                        <div>
                                            <a href="<%=request.getContextPath()%>/trip"><i class=" btn btn-link fa fa-list mt-1 ml-4" aria-hidden="true"
                                                    style="color: DodgerBlue;"> Trip
                                                    list</i></a>
                                        </div>
                                        <!-- Add Trip -->
                                        <div>
                                            <div class="dropdown-divider"></div>
                                            <a href="<%=request.getContextPath()%>/add-trip"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
                                                    aria-hidden="true" style="color: DodgerBlue;"> Add
                                                    Trip</i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Ticket manager -->
                            <div class="dropdown-divider"></div>
                            <div class="row">
                                <div class=" col-12 pl-2">
                                    <button class="btn btn-light dropdown-toggle " type="button" data-toggle="collapse"
                                        data-target="#collapse5"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <i class="fa fa-ticket" aria-hidden="true" style="color: DodgerBlue">
                                            Ticket manager</i>
                                    </button>

                                    <div class="collapse form-group" id="collapse5"
                                        style="background-color: rgb(248, 249, 249); color: DodgerBlue; border: 0px">
                                        <div class="dropdown-divider"></div>
                                        <!-- Ticket List -->
                                        <div>
                                            <a href="<%=request.getContextPath()%>/list-ticket"><i class=" btn btn-link fa fa-list mt-1 ml-4" aria-hidden="true"
                                                    style="color: DodgerBlue;"> Ticket
                                                    list</i></a>
                                        </div>
                                        <!-- Add Ticket -->
                                        <div>
                                            <div class="dropdown-divider"></div>
                                            <a href="<%=request.getContextPath()%>/list-ticket?action=add"><i class="  btn btn-link fa fa-plus mt-1 ml-4 "
                                                    aria-hidden="true" style="color: DodgerBlue;"> Add
                                                    Ticket</i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="dropdown-divider"></div>
                            <div class="row">
                                <div class="col py-8"></div>
                            </div>
                            <div class="row">
                                <div class="col py-4"></div>
                            </div>
                        </div>
                    </div>