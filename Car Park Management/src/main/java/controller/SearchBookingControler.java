package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingOfficeDAO;
import dao.impl.BookingOfficeDAOImpl;
import entities.BookingOffice;
import utils.CommonVariables;

/**
 * Servlet implementation class SearchBookingControler
 */
@WebServlet("/searchbooking")
public class SearchBookingControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBookingControler() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		String txt = request.getParameter("txtSearch");

		if (option.equals("officeName")) {
			option = "officeName";
		}
		if (option.equals("officePlace")) {
			option = "officePlace";
		}
		if (option.equals("destination")) {
			option = "destination";
		}

		try {

			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			BookingOfficeDAO bo = new BookingOfficeDAOImpl();
			int total = bo.countSearch(option, txt);
			int pageSize = CommonVariables.PAGE_SIZE;
			int maxPage = (total / pageSize);
			if (total % pageSize != 0) {
				maxPage++;
			}
			List<BookingOffice> listSearch = bo.Search(option, txt, index, pageSize);
			// so phan tu cua 1 trang
			request.setAttribute("listSearch", listSearch);
			// so trang
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("txt", txt);
			request.setAttribute("index", index);
			request.setAttribute("option", option);
			request.getRequestDispatcher("/views/SearchBooking.jsp").forward(request, response);
		} catch (Exception ex) {
			request.setAttribute("error", "Search booking failed");
			request.getRequestDispatcher("/views/error.jsp");
		}
	}

}
