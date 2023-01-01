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
 * Servlet implementation class ActionBookingOfficeController
 */
@WebServlet("/actionBookingOfficeController")
public class ActionBookingOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionBookingOfficeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = "";
			String action = request.getParameter("action");
			BookingOfficeDAO bookingDAO = new BookingOfficeDAOImpl();
			if (action.equals("view")) {
				int bookingID = Integer.parseInt(request.getParameter("officeId"));
				BookingOffice viewBooking = bookingDAO.getBookingOfficeById(bookingID);
				if (viewBooking != null) {
					request.setAttribute("booking", viewBooking);
					url = "/views/ViewBookingOffice.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			}

			if (action.equals("update")) {
				int bookingID = Integer.parseInt(request.getParameter("officeId"));
				BookingOffice updateBooking = bookingDAO.getBookingOfficeById(bookingID);
				if (updateBooking != null) {
					request.setAttribute("booking", updateBooking);
					url = "/views/UpdateBooking.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			}

			if (action.equals("delete")) {
				int bookingID = Integer.parseInt(request.getParameter("officeId"));
				if (bookingDAO.deleleBookingOffice(bookingID) == true) {
					response.sendRedirect(request.getContextPath() + "/listBookingOffice");
				} else {
					request.setAttribute("error", "Can not delete data");
					url = "/views/error.jsp";
				}

			}
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
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
			BookingOfficeDAO bookingDAO = new BookingOfficeDAOImpl();
			if (action.equals("update")) {
				int id = Integer.parseInt(request.getParameter("officeId"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String priceStr = request.getParameter("price");
				if(utils.Validator.validatePhone(phone) == true &&
					utils.Validator.validateStringLength(name) == true &&
					utils.Validator.isIntNumber(priceStr) == true) {
					int price = Integer.parseInt(request.getParameter("price"));

					String place = request.getParameter("place");
					Date from = Date.valueOf(request.getParameter("from"));
					Date to = Date.valueOf(request.getParameter("to"));
					if(utils.Validator.validateFromDateAndToDate(from, to) == true) {
						Trip trip = new Trip();
						trip.setTripId(Integer.parseInt(request.getParameter("trip")));

						BookingOffice updateBooking = new BookingOffice(id, from, name, phone, place, price, to, trip);
						if (bookingDAO.updateBookingOffice(updateBooking) == true) {
							response.sendRedirect(request.getContextPath() + "/listBookingOffice");
						} else {
							request.setAttribute("error", "Update booking office failed");
							request.getRequestDispatcher("/views/error.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("error", "From date must earlier to date");
						request.getRequestDispatcher("/views/error.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("error", "Booking Office Name or Phone number or Price invalid");
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
