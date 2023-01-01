/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.UserDAO;
import Model.User;
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
@WebServlet(name = "EditUser", urlPatterns = {"/edituser"})
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id user from jsp
        int id = Integer.parseInt(request.getParameter("uid"));
        // truyen uid to dao
        UserDAO dao = new UserDAO();
        User u = dao.getUserByID(id);
        //truyen data tu sevelet to jsp 
        request.setAttribute("user", u);
        request.getRequestDispatcher("view/admin/edituser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server 
        int user_id = Integer.parseInt(request.getParameter("idUser"));
        String user_name = request.getParameter("names");
        String user_email = request.getParameter("email");
        String user_phone = request.getParameter("phone");
        String user_userName = request.getParameter("userName");
        String user_password = request.getParameter("pass");
        String user_address = request.getParameter("address");

        //set data
        User user = new User();
        user.setNames(user_name);
        user.setEmail(user_email);
        user.setPhone(user_phone);
        user.setUserName(user_userName);
        user.setPass(user_password);
        user.setAddress(user_address);
        user.setIdUser(user_id);
        
        // update data
        UserDAO dao = new UserDAO();
        dao.update(user);
        //chuyen huong sang list user
        response.sendRedirect("listuser");
    }

}
