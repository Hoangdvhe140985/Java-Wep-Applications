/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.SocialDAO;
import Model.Social;
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
@WebServlet(name = "ListSocial", urlPatterns = {"/listsocial"})
public class ListSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        SocialDAO dao = new SocialDAO();
        List<Social> social = dao.getListSocaial();
        //truyen data tu sevelet to jsp 
        request.setAttribute("social", social);
        request.getRequestDispatcher("view/admin/show-social.jsp").forward(request, response);
    }

}
