package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.ParkinglotDAO;
import dao.impl.EmployeeDAOImpl;
import dao.impl.ParkinglotDAOImpl;
import entities.Employee;
import entities.Parkinglot;
import utils.Validator;

/**
 * Servlet implementation class AddParkinglotController
 */
@WebServlet("/add-parkinglot")
public class AddParkinglotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParkinglotController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect(request.getContextPath() + "/views/add-parkinglot.jsp");
		} catch (Exception e) {
			request.setAttribute("error", "Can not access add parkinglot");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("Name");
			String place = request.getParameter("Place");
			String areaStr = request.getParameter("Area");
			String priceStr = request.getParameter("Price");
			if(Validator.validateStringLength(name) && Validator.isIntNumber(areaStr) == true
					&& Validator.isIntNumber(priceStr) == true) {
				int area = Integer.parseInt(areaStr);
				int price = Integer.parseInt(priceStr);
				Parkinglot parkinglot = new Parkinglot(0, area, name, place, price, "Blank");
				ParkinglotDAO pakParkinglotDAO = new ParkinglotDAOImpl();
				if(pakParkinglotDAO.addParkinglot(parkinglot) ==  true) {
					request.setAttribute("noti", "Add parkinglot successfully");
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("noti", "Add parkinglot failed");
					request.setAttribute("alert", "danger");
				}
			} else {
				request.setAttribute("noti", "Name, Area or Price invalid");
				request.setAttribute("alert", "danger");
			}
			request.getRequestDispatcher("/views/add-parkinglot.jsp").forward(request, response);;
			
			
		} catch (Exception e) {
			request.setAttribute("error", "Add parkinglot failed");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
