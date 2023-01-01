package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.Validator;

import dao.BookingOfficeDAO;
import dao.impl.BookingOfficeDAOImpl;
import entities.BookingOffice;
import entities.Trip;

/**
 * Servlet implementation class AddBookingController
 */
@WebServlet("/addBooking")
public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookingController() {
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
			response.sendRedirect(request.getContextPath() + "/views/AddBooking.jsp");
		} catch (Exception e) {
			request.setAttribute("error", "Can not access add employee");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
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
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String priceStr = request.getParameter("price");
			if(utils.Validator.validatePhone(phone) == true &&
					utils.Validator.validateStringLength(name) == true &&
					utils.Validator.isIntNumber(priceStr) == true) {
				String place = request.getParameter("place");
				int price = Integer.parseInt(priceStr);
				Date from = Date.valueOf(request.getParameter("from"));
				Date to = Date.valueOf(request.getParameter("to"));
				if(utils.Validator.validateFromDateAndToDate(from, to) == true) {
					Trip trip = new Trip();
					trip.setTripId(Integer.parseInt(request.getParameter("trip")));

					BookingOfficeDAO bookingDAO = new BookingOfficeDAOImpl();
					BookingOffice addBooking = new BookingOffice(to, name, phone, place, price, from, trip);

					if (bookingDAO.addBookingOffice(addBooking) == true) {
						request.setAttribute("noti", "Add booking office successfully");
						request.setAttribute("alert", "success");
					} else {
						request.setAttribute("noti", "Add booking failed");
						request.setAttribute("alert", "danger");
					}
				} else {
					request.setAttribute("noti", "From date must earlier than to date");
					request.setAttribute("alert", "danger");
				}	
			} else {
				request.setAttribute("noti", "Booking Office Name or Phone number or Price invalid");
				request.setAttribute("alert", "danger");
			}
			request.getRequestDispatcher("/views/AddBooking.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Add booking failed");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
