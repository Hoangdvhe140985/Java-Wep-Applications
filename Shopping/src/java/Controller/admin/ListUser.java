/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.UserDAO;
import Model.User;
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
@WebServlet(name = "ListUser", urlPatterns = {"/listuser"})
public class ListUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUser();
        //truyen data tu sevelet to jsp 
        request.setAttribute("userList", users);
        request.getRequestDispatcher("view/admin/user.jsp").forward(request, response);
    }

}
