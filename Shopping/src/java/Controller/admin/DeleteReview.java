/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "DeleteReview", urlPatterns = {"/deletereview"})
public class DeleteReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id cate from jsp
        int id = Integer.parseInt(request.getParameter("rid"));
        // truyen uid to dao
        ReviewDAO dao = new ReviewDAO();
        dao.delete(id);
        //chuyen huong sang list 
        response.sendRedirect("showreview");
    }

}
