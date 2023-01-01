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
 * Servlet implementation class ListBookingControler
 */
@WebServlet("/listBookingOffice")
public class ListBookingControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookingControler() {
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
		try {
			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			BookingOfficeDAO bo = new BookingOfficeDAOImpl();
			int total = bo.countAll();
			int pageSize = CommonVariables.PAGE_SIZE;
			int maxPage = (total / pageSize);
			if (total % pageSize != 0) {
				maxPage++;
			}

			List<BookingOffice> listBooking = bo.getAllBookingOffice(index, pageSize);
			// so phan tu cua 1 trang
			request.setAttribute("listBooking", listBooking);
			// so trang
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("index", index);
			request.getRequestDispatcher("/views/ListBooking.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Can not update data");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
