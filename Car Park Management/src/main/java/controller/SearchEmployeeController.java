package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entities.Employee;
import utils.CommonVariables;

/**
 * Servlet implementation class SearchEmployeeController
 */
@WebServlet("/searchEmployee")
public class SearchEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployeeController() {
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
			String option = request.getParameter("option");
			String txt = request.getParameter("txtSearch");

			if (option.equals("employeeName")) {
				option = "employeeName";
			}
			if (option.equals("department")) {
				option = "department";
			}
			if (option.equals("employeeAddress")) {
				option = "employeeAddress";
			}
//			if (option.equals("employeeBirthdate")) {
//				option = "employeeBirthdate";
//			}
			if (option.equals("employeePhone")) {
				option = "employeePhone";
			}

			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			EmployeeDAO em = new EmployeeDAOImpl();
			int total = em.count(option, txt);
			int pageSize = CommonVariables.PAGE_SIZE;
			int maxPage = (total / pageSize);
			if (total % pageSize != 0) {
				maxPage++;
			}
			List<Employee> listSearch = em.Search(option, txt, index, pageSize);
			// so phan tu cua 1 trang
			request.setAttribute("listSearch", listSearch);
			// so trang
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("txt", txt);
			request.setAttribute("index", index);
			request.setAttribute("option", option);
			request.getRequestDispatcher("/views/SearchEmployee.jsp").forward(request, response);
		} catch (SQLException ex) {
			request.setAttribute("error", "Search employee failed");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
