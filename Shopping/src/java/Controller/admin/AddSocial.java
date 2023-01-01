/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.SocialDAO;
import Model.Social;
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
@WebServlet(name = "AddSocial", urlPatterns = {"/addsocial"})
public class AddSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //chuyển sang trang jsp
        request.getRequestDispatcher("view/admin/addsocial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //get data from jsp to severlet
        String url = request.getParameter("url");
        // truyen sang dao
        Social social = new Social();
        social.setUrl(url);
        //insert data to database
        SocialDAO dao = new SocialDAO();
        dao.insert(social);
        response.sendRedirect("listsocial");
    }

}
