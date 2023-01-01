/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ReviewDAO;
import Model.Review;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ReviewClientController", urlPatterns = {"/reviewclientcontroller"})
public class ReviewClientController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //chuyen sang trang jsp
        request.getRequestDispatcher("Shop-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //get data from client to server
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        //format date
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(date);

        //set data
        Review review = new Review();
        review.setName(name);
        review.setEmail(email);
        review.setProduct_id(id);
        review.setContent(content);
        review.setCreated(today);
        //insert data to database
        ReviewDAO dao = new ReviewDAO();
        dao.insert(review);
        response.sendRedirect("shopdetails?id=" + id);
    }

}
