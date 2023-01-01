package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TripDAO;
import dao.impl.TripDAOImpl;
import entities.Trip;

/**
 * Servlet implementation class AddTripController
 */
@WebServlet("/add-trip")
public class AddTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTripController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect(request.getContextPath() + "/views/add-trip.jsp");
		} catch (Exception e) {
			request.setAttribute("error", "Can not access add employee");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int bookedTicketNumber = 0;
			String carType = request.getParameter("carType");
			Date departureDate = Date.valueOf(request.getParameter("date"));
		    Time departureTime = Time.valueOf(request.getParameter("time").substring(0, 5)+":00");
			String destination = request.getParameter("destination");
			String driver = request.getParameter("driver");
			int maximumOnlineTicketNumber = Integer.parseInt(request.getParameter("ticket"));
			Trip trip = new Trip(bookedTicketNumber, carType, departureDate, departureTime, destination, driver, maximumOnlineTicketNumber);
			TripDAO tripDAO = new TripDAOImpl();
			if (tripDAO.addTrip(trip) == true) {
				request.setAttribute("noti", "Add trip successfully");
				request.setAttribute("alert", "success");
			}else {
				request.setAttribute("noti", "Add trip failed");
				request.setAttribute("alert", "danger");
			}
			request.getRequestDispatcher("/views/add-trip.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Add trip failed");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);;
		}
	}

}
