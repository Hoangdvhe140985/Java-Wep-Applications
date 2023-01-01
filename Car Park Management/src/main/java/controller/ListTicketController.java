package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.TicketDAO;
import dao.TripDAO;
import dao.impl.CarDAOImpl;
import dao.impl.TicketDAOImpl;
import dao.impl.TripDAOImpl;
import entities.Car;
import entities.Ticket;
import entities.Trip;
import utils.CommonVariables;

/**
 * Servlet implementation class ListParkinglotController
 */
@WebServlet("/list-ticket")
public class ListTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		try {
			TicketDAO ticketDAO = new TicketDAOImpl();
			String action = request.getParameter("action");
			boolean flagRedirect = true;
			if(action == null) {
				int index = 1;
				int numberOfTicket = ticketDAO.getNumberOfTickets();
				int numberOfPage = numberOfTicket / CommonVariables.PAGE_SIZE;
				if (numberOfTicket % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Ticket> listTicket = ticketDAO.getTicketByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("numberOfPage", numberOfPage);
				request.setAttribute("listTickets", listTicket);
				url = "/views/list-ticket.jsp";
			} else if(action.equals("listTicket")) {
				int index = Integer.parseInt(request.getParameter("index"));
				int numberOfTicket = ticketDAO.getNumberOfTickets();
				int numberOfPage = numberOfTicket / CommonVariables.PAGE_SIZE;
				if (numberOfTicket % CommonVariables.PAGE_SIZE != 0) {
					numberOfPage++;
				}
				List<Ticket> listTicket = ticketDAO.getTicketByIndexPage(index, CommonVariables.PAGE_SIZE);
				request.setAttribute("index", index);
				request.setAttribute("numberOfPage", numberOfPage);
				request.setAttribute("listTickets", listTicket);
				url = "/views/list-ticket.jsp";
			} else if (action.equals("update")) {
				TripDAO tripDAO = new TripDAOImpl();
				CarDAO carDAO = new CarDAOImpl();
				int ticketId = Integer.parseInt(request.getParameter("ticketId"));
				List<Trip> listTrip = tripDAO.getAllTrip();
				List<Car> listCar = carDAO.getAllCar();
				Ticket ticket = ticketDAO.getTicketById(ticketId);
				request.setAttribute("listTrip", listTrip);
				request.setAttribute("listCar", listCar);
				request.setAttribute("ticket", ticket);
				url = "/views/update-ticket.jsp";
			} else if (action.equals("add")) {
				url = "/views/add-ticket.jsp";
				TripDAO tripDAO = new TripDAOImpl();
				CarDAO carDAO = new CarDAOImpl();
				List<Trip> listTrip = tripDAO.getAllTrip();
				List<Car> listCar = carDAO.getAllCar();
				request.setAttribute("listTrip", listTrip);
				request.setAttribute("listCar", listCar);
			} else if (action.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("ticketId"));
				if(ticketDAO.deleleTicket(id) == true) {
					flagRedirect = false;
					response.sendRedirect(request.getContextPath() + "/list-ticket");
				} else {
					request.setAttribute("error", "Delete ticket failed");
					url = "/views/error.jsp";
				}
			} else if (action.equals("search")) {
				flagRedirect = false;
				doPost(request, response);
			}
			if(flagRedirect ==  true) {
				request.getRequestDispatcher(url).forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "Load data failed");
			url = "/views/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		try {
			String action = request.getParameter("action");
			TicketDAO ticketDAO = new TicketDAOImpl();
			boolean flag = true;
			if(action.equals("update")) {
				int ticketId = Integer.parseInt(request.getParameter("id"));
				String customerName = request.getParameter("name");
				String bookingTimeStr = request.getParameter("booking-time");
				if(bookingTimeStr.length() < 8) {
					bookingTimeStr += ":00";
				}
				Time bookingTime = Time.valueOf(bookingTimeStr);
				String licensenPlate = request.getParameter("car");
				System.out.println(licensenPlate);
				int tripId = Integer.parseInt(request.getParameter("trip"));
				Ticket ticket = new Ticket(ticketId, bookingTime, customerName, licensenPlate, tripId);
				if(ticketDAO.updateTicket(ticket) == true) {
					flag = false;
					response.sendRedirect(request.getContextPath() + "/list-ticket");
				} else {
					request.setAttribute("error", "Update ticket failed");
					url = "/views/error.jsp";
				}
			} else if (action.equals("add")) {
				TripDAO tripDAO = new TripDAOImpl();
				CarDAO carDAO = new CarDAOImpl();
				List<Trip> listTrip = tripDAO.getAllTrip();
				List<Car> listCar = carDAO.getAllCar();
				if(listCar == null || listTrip == null) {
					request.setAttribute("error", "Load add ticket page failed");
					url = "/views/error.jsp";
				} else {
					request.setAttribute("listTrip", listTrip);
					request.setAttribute("listCar", listCar);
					String customerName = request.getParameter("name");
					String bookingTimeStr = request.getParameter("booking-time");
					if(bookingTimeStr.length() < 8) {
						bookingTimeStr += ":00";
					}
					Time bookingTime = Time.valueOf(bookingTimeStr);
					int tripId = Integer.parseInt(request.getParameter("trip"));
					String licensePlate = request.getParameter("car");
					Ticket ticket = new Ticket(0, bookingTime, customerName, licensePlate, tripId);
					url = "/views/add-ticket.jsp";
					if(ticketDAO.addTicket(ticket) == true) {
						request.setAttribute("noti", "Add ticket successfully");
						request.setAttribute("arlet", "success");
					} else {
						request.setAttribute("noti", "Add ticket failed");
						request.setAttribute("arlet", "danger");
					}
				}
				
			} else if (action.equals("search")) {
				String searchStr = request.getParameter("search");
				String filter = request.getParameter("filter");
				String dateStr = request.getParameter("dateStr");
				if(dateStr == null) {
					String day = request.getParameter("day");
					String month = request.getParameter("month");
					String year = request.getParameter("year");
					dateStr = year + "-" + month + "-" + day;	
				}
				Date date = Date.valueOf(dateStr);
				int indexSearch = Integer.parseInt(request.getParameter("indexSearch"));
				int numberOfTicket = ticketDAO.getNumberOfTikcetSearch(filter, searchStr, date);
				if(numberOfTicket > 0) {
					int numberOfPage = numberOfTicket / CommonVariables.PAGE_SIZE;
					System.out.println(numberOfPage);
					if(numberOfTicket % CommonVariables.PAGE_SIZE != 0) {
						System.out.println(numberOfPage % CommonVariables.PAGE_SIZE);
						numberOfPage++;
					}
					System.out.println(numberOfPage);
					List<Ticket> listTicket = ticketDAO.getTicketSearchByIndexPage(filter, searchStr, date, indexSearch, CommonVariables.PAGE_SIZE);
					request.setAttribute("dateStr", dateStr);
					request.setAttribute("filter", filter);
					request.setAttribute("search", searchStr);
					request.setAttribute("listTickets", listTicket);
					request.setAttribute("index", indexSearch);
					request.setAttribute("numberOfPage", numberOfPage);
					request.setAttribute("paging", 1);
					url = "/views/list-ticket.jsp";
					
				} else {
					request.setAttribute("notification", "No tickets found");
					url = "/views/list-ticket.jsp";
				}
				
			}
			if(flag == true) {
				request.getRequestDispatcher(url).forward(request, response);	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "Load ticket failed");
			url = "/views/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
