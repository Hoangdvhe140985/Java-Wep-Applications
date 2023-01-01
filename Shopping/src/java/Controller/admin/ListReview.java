/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ReviewDAO;
import Model.Review;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ListReview", urlPatterns = {"/showreview"})
public class ListReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        ReviewDAO dao = new ReviewDAO();
        List<Review> list = dao.getAll();
        //truyen data tu sevelet to jsp 
        request.setAttribute("reviewlist", list);
        request.getRequestDispatcher("view/admin/show-review.jsp").forward(request, response);
    }

}
