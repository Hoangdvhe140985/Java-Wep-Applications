package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.ParkinglotDAO;
import dao.impl.CarDAOImpl;
import dao.impl.ParkinglotDAOImpl;
import entities.Car;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet("/add-car")
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ParkinglotDAO parkinglotDao = new ParkinglotDAOImpl();
			request.setAttribute("parkinglots", parkinglotDao.getAllParkinglot());
			request.getRequestDispatcher("/views/add-car.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/views/add-car.jsp");
			
		} catch (Exception e) {
			request.setAttribute("error", "Can not access add car");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String licensePlate = request.getParameter("licensePlate");
			String carType = request.getParameter("carType");
			String carColor = request.getParameter("carColor");
			String company = request.getParameter("company");
			int parkId = Integer.parseInt(request.getParameter("parkId"));
			Car car = new Car(licensePlate,carColor,carType,company,parkId);
			CarDAO carDAO = new CarDAOImpl();
			if(carDAO.addCar(car) == true) {
				response.sendRedirect(request.getContextPath() + "/list-car");
			} else {
				request.setAttribute("alert", "danger");
				request.setAttribute("mess", "Add Car Failed!");

//				request.setAttribute("error", "Add parkinglot failed");
				request.getRequestDispatcher("/views/add-car.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("alert", "danger");
			request.setAttribute("mess", "Add Car Failed!");
			
			ParkinglotDAO parkinglotDao = new ParkinglotDAOImpl();
			try {
				request.setAttribute("parkinglots", parkinglotDao.getAllParkinglot());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
//			request.setAttribute("error", "Add parkinglot failed");
			request.getRequestDispatcher("/views/add-car.jsp").forward(request, response);
		}
	}

}
