package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entities.Employee;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");

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
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			String account = request.getParameter("account");
	        String password = request.getParameter("password");
	        Employee acc = employeeDAO.getLoginEmployee(account, password);
	        String url = "";
	        if (acc != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("account", acc);
	            if(acc.getRole() == 1) {
	            	url = request.getContextPath() + "/list-employee";
	            } else {
	            	url = request.getContextPath() + "/list-ticket";
	            }
	            response.sendRedirect(url);
	        }else{
	            request.setAttribute("show", "Login failed!");
	            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	        }
		} catch (Exception e) {
			request.setAttribute("show", "Login failed!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
