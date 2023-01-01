/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ContactDAO;
import DAO.SocialDAO;
import DAO.RegisterDAO;
import Model.User;
import Model.Contact;
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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data
        SocialDAO SociDao = new SocialDAO();
        List<Social> social = SociDao.getListSocaial();
        ContactDAO ContactDAO = new ContactDAO();
        Contact contact = ContactDAO.getConById(1);
        // set data object
        request.setAttribute("social", social);
        request.setAttribute("contact", contact);
        //chuyển sang trang đăng kí
        request.getRequestDispatcher("Register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");

        RegisterDAO register = new RegisterDAO();
        //get data from cliient to server
        String username = request.getParameter("username");
        //check username
        if (register.checkAccountExist(username) != true) {
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            boolean gender = request.getParameter("gender").equals("male");
            int role = 0;
            //set data
            User newuser = new User(username, password, name, gender, address, email, phone, role);
            //mess thông báo
            request.setAttribute("msg", "Bạn đã tạo tài khoàn thành công. Mời bạn đăng nhập bên dưới !");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            //mess thông báo
            request.setAttribute("errmsg", "Tạo tài khoản thất bại. Hãy thử lại !!!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }

    }

}
