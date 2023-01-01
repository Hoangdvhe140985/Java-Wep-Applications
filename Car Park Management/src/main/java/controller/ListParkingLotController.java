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
import dao.impl.CarDAOImpl;
import dao.impl.ParkinglotDAOImpl;
import entities.Parkinglot;
import utils.CommonVariables;

/**
 * Servlet implementation class ListParkingLotController
 */
@WebServlet("/list-parkinglot")
public class ListParkingLotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListParkingLotController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ParkinglotDAO paDao = new ParkinglotDAOImpl();
			String url = "";
			String action = request.getParameter("action");
			if (action == null) {
				action = "viewParkinglot&index=1";
			}

			if (action.equals("viewParkinglot&index=1")) {
				int numberOfStaff = paDao.getTotalParkinglot();
				int numberOfPage = numberOfStaff / CommonVariables.PAGE_SIZE;
				if (numberOfStaff % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Parkinglot> list = paDao.getParkinglotByIndexPage(1, CommonVariables.PAGE_SIZE);
				request.setAttribute("listParkinglot", list);
				request.setAttribute("index", 1);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-parkinglot.jsp";
			}

			if (action.equals("viewParkinglot")) {
				String indexPage = request.getParameter("index");
				int index = Integer.parseInt(indexPage);
				int numberOfStaff = paDao.getTotalParkinglot();
				int numberOfPage = numberOfStaff / CommonVariables.PAGE_SIZE;
				if (numberOfStaff % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Parkinglot> list = paDao.getParkinglotByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("listParkinglot", list);
				request.setAttribute("numberOfPage", numberOfPage);
				url = "/views/list-parkinglot.jsp";
			}

			if (action.equals("edit")) {
				int parkinglotId = Integer.parseInt(request.getParameter("parkinglotId"));
				Parkinglot editParkinglot = paDao.getParkinglotById(parkinglotId);
				if (editParkinglot != null) {
					request.setAttribute("parkinglot", editParkinglot);
					url = "/views/edit-parkinglot.jsp";
				} else {
					request.setAttribute("error", "Can not view data");
					url = "/views/error.jsp";
				}
			}

			if (action.equals("delete")) {
				int parkinglotId = Integer.parseInt(request.getParameter("parkinglotId"));
				//
				CarDAO carDAO = new CarDAOImpl();
				if(carDAO.checkCarContainParkinglot(parkinglotId) != true) {
					if (paDao.deleleParkinglot(parkinglotId) == true) {
						response.sendRedirect(request.getContextPath() + "/list-parkinglot");
					} else {
						request.setAttribute("error", "Can not delete data");
						url = "/views/error.jsp";
					}
				} else {
					request.setAttribute("error", "Can not delete data because still have Car contain parkinglot");
					url = "/views/error.jsp";
				}
				

			}
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
			ParkinglotDAO parkinglotDAO = new ParkinglotDAOImpl();
			if (action.equals("edit")) {
				int parkId = Integer.parseInt(request.getParameter("id"));
				int parkArea = Integer.parseInt(request.getParameter("parkArea"));
				String parkName = request.getParameter("parkName");
				String parkPlace = request.getParameter("parkPlace");
				int parkPrice = Integer.parseInt(request.getParameter("parkPrice"));
				String parkStatus = request.getParameter("parkStatus");
				Parkinglot editParkinglot = new Parkinglot(parkId, parkArea, parkName, parkPlace, parkPrice,
						parkStatus);
				if (parkinglotDAO.updateParkinglot(editParkinglot) == true) {
					response.sendRedirect(request.getContextPath() + "/list-parkinglot");
				} else {
					request.setAttribute("error", "Edit Parkinglot failed");
					request.getRequestDispatcher("/views/error.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "Can not edit data");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

}