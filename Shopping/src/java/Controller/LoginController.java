/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ContactDAO;
import DAO.LoginDAO;
import DAO.SocialDAO;
import Model.Contact;
import Model.Social;
import Model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoang
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get data 
        SocialDAO SociDao = new SocialDAO();
        List<Social> social = SociDao.getListSocaial();
        ContactDAO ContactDAO = new ContactDAO();
        Contact contact = ContactDAO.getConById(1);
        //set data gui sang jsp
        request.setAttribute("social", social);
        request.setAttribute("contact", contact);
        //chuyền sang trang jsp
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get data form client to sever
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //check login
        LoginDAO loginDao = new LoginDAO();
        User u = loginDao.checkLogin(username, password);
        //if user ton tai
        if (u != null) {
            // khoi tao session
            HttpSession session = request.getSession();
            //gán giá trị cho session
            session.setAttribute("username", username);
            //check roll
            if (u.getRole() == 0) {
                // = 0 là user
                response.sendRedirect("listproduct");
            } else {
                // khac  0 là admin
                response.sendRedirect("adminhome");
            }
            //login fail mess error
        } else {
            request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

}
