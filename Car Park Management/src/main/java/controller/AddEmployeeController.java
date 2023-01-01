package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import entities.Employee;
import utils.Validator;

/**
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/add-employee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect(request.getContextPath() + "/views/add-employee.jsp");
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
		String url = "";
		try {
			url = "/views/add-employee.jsp";
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			String employeeName = request.getParameter("Name");
			String phone = request.getParameter("Phone");
			if(Validator.validateStringLength(employeeName) == true && Validator.validatePhone(phone) == true) {
				Date birthDate = Date.valueOf(request.getParameter("Date"));
				long millis = System.currentTimeMillis();
				Date currentDate = new Date(millis);
				if(Validator.validateFromDateAndToDate(birthDate, currentDate) == true) {
					int sex = Integer.parseInt(request.getParameter("sex"));
					String address = request.getParameter("Address");
					String email = request.getParameter("Email");
					String account = request.getParameter("Account");
					if(employeeDAO.checkAccountExist(account) != true) {
						String password = request.getParameter("Password");
						String department = request.getParameter("Department");
						Employee newEmployee = new Employee(0, account, department, address, birthDate, email, employeeName, phone, password, sex, 0);
						if(employeeDAO.addEmployee(newEmployee) ==  true) {
							request.setAttribute("noti", "Add employee successfully");
							request.setAttribute("alert", "success");
						} else {
							request.setAttribute("noti", "Add employee failed");
							request.setAttribute("alert", "danger");
						}	
					} else {
						request.setAttribute("noti", "Account already exist");
						request.setAttribute("alert", "danger");
					}
				} else {
					request.setAttribute("noti", "Birthdate must ealier than today");
					request.setAttribute("alert", "danger");
				}
			} else {
				request.setAttribute("noti", "Name or phone number invalid");
				request.setAttribute("alert", "danger");
			}
			
			
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Add employee failed");
			url = "/views/error.jsp";
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
