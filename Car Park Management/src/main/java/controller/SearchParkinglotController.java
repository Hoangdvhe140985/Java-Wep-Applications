package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkinglotDAO;
import dao.impl.ParkinglotDAOImpl;
import entities.Parkinglot;
import utils.CommonVariables;

/**
 * Servlet implementation class SearchParkinglotController
 */
@WebServlet("/search-parkinglot")
public class SearchParkinglotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchParkinglotController() {
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
		try {
			String option = request.getParameter("option");
			String txt = request.getParameter("txtSearch");

			if (option.equals("parkName")) {
				option = "parkName";
			}
			if (option.equals("parkPlace")) {
				option = "parkPlace";
			}
			if (option.equals("parkArea")) {
				option = "parkArea";
			}
			if (option.equals("parkPrice")) {
				option = "parkPrice";
			}
			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			ParkinglotDAO paDao = new ParkinglotDAOImpl();
			int total = paDao.countSearch(option, txt);
			int pageSize = CommonVariables.PAGE_SIZE;
			int maxPage = (total / pageSize);
			if (total % pageSize != 0) {
				maxPage++;
			}
			List<Parkinglot> listSearch = paDao.search(option, txt, index, pageSize);
			request.setAttribute("listSearch", listSearch);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("txt", txt);
			request.setAttribute("index", index);
			request.setAttribute("option", option);
			request.getRequestDispatcher("/views/search-parkinglot.jsp").forward(request, response);
		} catch (Exception ex) {
			request.setAttribute("error", "Search Parkinglot failed");
			request.getRequestDispatcher("/views/error.jsp");
		}

	}
}
