package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.sql.Time;

import dao.BookingOfficeDAO;
import dao.TicketDAO;
import dao.TripDAO;
import dao.impl.BookingOfficeDAOImpl;
import dao.impl.TicketDAOImpl;
import dao.impl.TripDAOImpl;
import entities.Trip;
import utils.CommonVariables;

/**
 * Servlet implementation class ListTripController
 */
@WebServlet("/trip")
public class ListTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTripController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			TripDAO tripDAO = new TripDAOImpl();
			String url = "";
			String action = request.getParameter("action");
			if (action == null) {
				action = "viewTrips&index=1";
			}
			if (action.equals("viewTrips&index=1")) {
				int numberOfTrips = tripDAO.getNumberOfTrips();
				int numberOfPage = numberOfTrips / CommonVariables.PAGE_SIZE;
				if (numberOfTrips % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Trip> list = tripDAO.getTripsByIndexPage(1, CommonVariables.PAGE_SIZE);
				request.setAttribute("listTrip", list);
				request.setAttribute("index", 1);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-trip.jsp";
			}

			if (action.equals("viewTrips")) {
				int index = Integer.parseInt(request.getParameter("index"));
				int numberOfTrip = tripDAO.getNumberOfTrips();
				int numberOfPage = numberOfTrip / CommonVariables.PAGE_SIZE;
				if (numberOfTrip % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Trip> list = tripDAO.getTripsByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("listTrip", list);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-trip.jsp";
			}
			if (action.equals("update")) {
				int tripId = Integer.parseInt(request.getParameter("tripId"));
				Trip updateTrip = tripDAO.getTripById(tripId);
				if (updateTrip != null) {
					request.setAttribute("trip", updateTrip);
					url = "/views/update-trip.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			}

			if (action.equals("delete")) {
				int tripId = Integer.parseInt(request.getParameter("tripId"));
				TicketDAO ticketDAO = new TicketDAOImpl();
				BookingOfficeDAO bookingOfficeDAO = new BookingOfficeDAOImpl();
				if(ticketDAO.countTicketsContainTrip(tripId) != true && 
						bookingOfficeDAO.countBookingOfficesContainTrip(tripId) != true) {
					if (tripDAO.deleleTrip(tripId) == true) {
						response.sendRedirect(request.getContextPath() + "/trip");
					} else {
						request.setAttribute("error", "Can not delete data");
						url = "/views/error.jsp";
					}
				} else {
					request.setAttribute("error", "Can not delete data because ticket or booking office contain trip still exist");
					url = "/views/error.jsp";
				}
				

			}
			if (action.equals("searchTrip")) {
				int day = Integer.parseInt(request.getParameter("day"));
				int month = Integer.parseInt(request.getParameter("month"));
				int year = Integer.parseInt(request.getParameter("year"));
				String indexPage = request.getParameter("index");
				List<Trip> list = null;
				int numberOfTripsByDMY = tripDAO.getNumberOfTripsByDayMonthYear(day, month, year);
				int numberOfPage = numberOfTripsByDMY / CommonVariables.PAGE_SIZE;
				if (numberOfTripsByDMY % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				if (indexPage == null) {
					request.setAttribute("index", 1);
					list = tripDAO.getTripsByDMYAndIndexPage(day, month, year, 1, CommonVariables.PAGE_SIZE);
				} else {
					int index = Integer.parseInt(indexPage);
					list = tripDAO.getTripsByDMYAndIndexPage(day, month, year, index, CommonVariables.PAGE_SIZE);
					request.setAttribute("index", index);
				}
				request.setAttribute("numberOfPage", numberOfPage);
				request.setAttribute("day", day);
				request.setAttribute("month", month);
				request.setAttribute("year", year);
				request.setAttribute("listTrip", list);
				url = "/views/list-search-trip.jsp";
			}
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");
			TripDAO tripDAO = new TripDAOImpl();
			if (action.equals("update")) {
				int tripId = Integer.parseInt(request.getParameter("tripId"));
				int bookedTicketNumber = Integer.parseInt(request.getParameter("booked"));
				String carType = request.getParameter("carType");
				Date departureDate = Date.valueOf(request.getParameter("date"));
				Time departureTime = Time.valueOf(request.getParameter("time").substring(0, 5) + ":00");
				String destination = request.getParameter("destination");
				String driver = request.getParameter("driver");
				int maximumOnlineTicketNumber = Integer.parseInt(request.getParameter("ticket"));
				Trip trip = new Trip(tripId, bookedTicketNumber, carType, departureDate, departureTime, destination,
						driver, maximumOnlineTicketNumber);
				if (tripDAO.updateTrip(trip) == true) {
					response.sendRedirect(request.getContextPath() + "/trip");
				} else {
					request.setAttribute("error", "Update trip failed");
					request.getRequestDispatcher("/views/error.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "Can not update data");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
