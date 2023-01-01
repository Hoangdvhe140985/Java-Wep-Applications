package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Employee;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(urlPatterns = {"/actionBookingOfficeController", "/addBooking", "/add-car", "/add-parkinglot",
		"/add-trip", "/listBookingOffice", "/list-car", "/list-parkinglot", "/list-ticket",
		"/trip", "/searchbooking", "/search-parkinglot", "/views/AddBooking.jsp", "/views/add-car.jsp",
		"/views/add-parkinglot.jsp", "/views/add-ticket.jsp", "/views/add-trip.jsp", 
		"/views/edit-parkinglot.jsp", "/views/ListBooking.jsp", "/views/list-car.jsp", 
		"/views/list-parkinglot.jsp", "/views/list-search-trip.jsp", "/views/list-ticket.jsp",
		"/views/list-trip.jsp", "/views/SearchBooking.jsp", "/views/SearchEmployee.jsp",
		"/views/search-parkinglot.jsp", "/views/UpdateBooking.jsp", "/views/update-car.jsp", 
		"/views/update-employee.jsp", "/views/update-ticket.jsp", "/views/update-trip.jsp",
		"/views/ViewBookingOffice.jsp", "/views/view-employee.jsp"})
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Employee em = (Employee) session.getAttribute("account");
		if(em == null || em.getRole() != 0) {
			res.sendRedirect(req.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
