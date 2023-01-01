package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.ParkinglotDAO;
import dao.TicketDAO;
import dao.impl.CarDAOImpl;
import dao.impl.ParkinglotDAOImpl;
import dao.impl.TicketDAOImpl;
import entities.Car;
import utils.CommonVariables;

/**
 * Servlet implementation class ListCarController
 */
@WebServlet("/list-car")
public class ListCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		try {
			CarDAO carDAO = new CarDAOImpl();
			String action = request.getParameter("action");
			boolean flagRedirect = true;
			if (action == null) {
				int index = 1;
				int numberOfCar = carDAO.getNumberOfCars();
				int numberOfPage = numberOfCar / CommonVariables.PAGE_SIZE;
				if (numberOfCar % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Car> listCar = carDAO.getCarByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("numberOfPage", numberOfPage);
				request.setAttribute("listCars", listCar);
				url = "/views/list-car.jsp";

			} else if (action.equals("listCar")) {
				int index = Integer.parseInt(request.getParameter("index"));
				int numberOfCar = carDAO.getNumberOfCars();
				int numberOfPage = numberOfCar / CommonVariables.PAGE_SIZE;
				if (numberOfCar % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Car> listCar = carDAO.getCarByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("numberOfPage", numberOfPage);
				request.setAttribute("listCars", listCar);
				url = "/views/list-car.jsp";
			} else if (action.equals("delete")) {
				String plate = request.getParameter("licensePlate");
				TicketDAO ticketDAO = new TicketDAOImpl();
				if(ticketDAO.checkTicketContainCar(plate) != true) {
					if (carDAO.deleteCar(plate) == true) {
						flagRedirect = false;
						response.sendRedirect(request.getContextPath() + "/list-car");
					} else {
						request.setAttribute("error", "Delete Car failed");
						url = "/views/error.jsp";
					}
				} else {
					request.setAttribute("error", "Delete Car failed because still have ticket contains Car");
					url = "/views/error.jsp";
				}
				
			} else if (action.equals("update")) {
				String plate = request.getParameter("licensePlate");
				Car updateCar = carDAO.getCarByLisencePlate(plate);
				if (updateCar != null) {
					ParkinglotDAO parkinglotDao = new ParkinglotDAOImpl();
					request.setAttribute("car", updateCar);
					request.setAttribute("parkinglots", parkinglotDao.getAllParkinglot());
					url = "/views/update-car.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			} else if (action.equals("searchCar")) {
				flagRedirect = false;
				doPost(request, response);
			}

			if (flagRedirect == true) {
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "Load data failed");
			url = "/views/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			CarDAO carDAO = new CarDAOImpl();
			if (action.equals("update")) {
				String licensePlate = request.getParameter("licensePlate");
				String carType = request.getParameter("carType");
				String carColor = request.getParameter("carColor");
				String company = request.getParameter("company");
				int parkId = Integer.parseInt(request.getParameter("parkId"));
				Car car = new Car(licensePlate, carColor, carType, company, parkId);
				if (carDAO.updateCar(car) == true) {
					response.sendRedirect(request.getContextPath() + "/list-car");
				} else {
					request.setAttribute("error", "Update car failed");
					request.getRequestDispatcher("/views/error.jsp").forward(request, response);
				}
			} else if (action.equals("searchCar")) {

				String filter = request.getParameter("filter");
				String txt = request.getParameter("txt");

				int indexSearch = Integer.parseInt(request.getParameter("indexSearch"));
				int numberOfCar = carDAO.countSearch(filter, txt);
				if (numberOfCar > 0) {
					int numberOfPage = numberOfCar / CommonVariables.PAGE_SIZE;
					if (numberOfCar % CommonVariables.PAGE_SIZE != 0) {
						numberOfPage++;
					}
					List<Car> listSearch = carDAO.searchCar(filter, txt, indexSearch, CommonVariables.PAGE_SIZE);
					request.setAttribute("filter", filter);
					request.setAttribute("txt", txt);
					request.setAttribute("index", indexSearch);
					request.setAttribute("listCars", listSearch);
					request.setAttribute("numberOfPage", numberOfPage);
					request.setAttribute("paging", 1);
					request.getRequestDispatcher("/views/list-car.jsp").forward(request, response);
				} else {
					request.setAttribute("notification", "No car found");
					request.getRequestDispatcher("/views/list-car.jsp").forward(request, response);
				}

			}

		} catch (Exception e) {
			request.setAttribute("error", "Can not update data");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}
