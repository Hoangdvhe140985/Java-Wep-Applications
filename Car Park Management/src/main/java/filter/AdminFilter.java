package filter;

import java.io.IOException;
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
 * Servlet Filter implementation class Filter
 */

@WebFilter(urlPatterns = {"/list-employee", "/searchEmployee", "/add-employee",
		"/views/list-employee.jsp", "/views/add-employee.jsp", "/views/SearchEmployee.jsp",
		"/views/update-employee.jsp", "/views/view-employee.jsp"})
public class AdminFilter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see AdminFilter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see AdminFilter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Employee em = (Employee) session.getAttribute("account");
		if(em == null || em.getRole() != 1) {
			res.sendRedirect(req.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see AdminFilter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
