package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entities.Employee;
import utils.CommonVariables;
import utils.Validator;

/**
 * Servlet implementation class ListEmployeeController
 */
@WebServlet("/list-employee")
public class ListEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmployeeController() {
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
			boolean flagRedirect = true;
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			String url = "";
			String action = request.getParameter("action");
			if (action == null) {
				action = "viewEmployees&index=1";
			}
			
			if (action.equals("viewEmployees&index=1")) {
				int numberOfStaff = employeeDAO.getNumberOfStaffs();// 10
				int numberOfPage = numberOfStaff / CommonVariables.PAGE_SIZE;
				if (numberOfStaff % CommonVariables.PAGE_SIZE > 0) {
					numberOfPage++;
				}
				List<Employee> list = employeeDAO.getEmployeesByIndexPage(1, CommonVariables.PAGE_SIZE);
				request.setAttribute("listEmployee", list);
				request.setAttribute("index", 1);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-employee.jsp";
			}
			
			if (action.equals("viewEmployees")) {
				String indexPage = request.getParameter("index");
				int index = Integer.parseInt(indexPage);
				int numberOfStaff = employeeDAO.getNumberOfStaffs();
				int numberOfPage = numberOfStaff / CommonVariables.PAGE_SIZE;
				if (numberOfStaff % CommonVariables.PAGE_SIZE > 0) {
					numberOfPage++;
				}
				List<Employee> list = employeeDAO.getEmployeesByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("listEmployee", list);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-employee.jsp";
			}
			
			if (action.equals("view")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				Employee viewEmployee = employeeDAO.getEmployeeById(employeeId);
				if (viewEmployee != null) {
					request.setAttribute("employee", viewEmployee);
					url = "/views/view-employee.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}

			}
			
			if (action.equals("update")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				Employee updateEmployee = employeeDAO.getEmployeeById(employeeId);
				if (updateEmployee != null) {
					request.setAttribute("employee", updateEmployee);
					url = "/views/update-employee.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			}
			
			if (action.equals("delete")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				if(employeeDAO.deleleEmployee(employeeId) == true) {
					flagRedirect = false;
					response.sendRedirect(request.getContextPath() + "/list-employee");
				} else {
					request.setAttribute("error", "Can not delete data");
					url = "/views/error.jsp"; 
				}
				
			}
			
			if(flagRedirect == true) {
				request.getRequestDispatcher(url).forward(request, response);
			}
		
		} catch (Exception e) {
			request.setAttribute("error", "Can not load data");
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
			String action = request.getParameter("action");
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			if(action.equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("Name");
				String phone = request.getParameter("Phone");
				Date date = Date.valueOf(request.getParameter("Date"));
				long millis = System.currentTimeMillis();
				Date currentDate = new Date(millis);
				if(Validator.validateFromDateAndToDate(date, currentDate) == true) {
					int sex =  Integer.parseInt(request.getParameter("sex"));
					String address = request.getParameter("Address");
					String email = request.getParameter("Email");
					String account = request.getParameter("Account");
					String password = request.getParameter("Password");
					String department = request.getParameter("Department");
					Employee updateEmployee = new Employee(id, account, department, address, date, email, name, phone, password, sex, 0);
					if(employeeDAO.updateEmployee(updateEmployee) == true) {
						response.sendRedirect(request.getContextPath() + "/list-employee");
					} else {
						request.setAttribute("error", "Update employee failed");
						request.getRequestDispatcher("/views/error.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("error", "Birthdate must earlier today");
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
