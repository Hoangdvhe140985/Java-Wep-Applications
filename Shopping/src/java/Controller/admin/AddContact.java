/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ContactDAO;
import Model.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "AddContact", urlPatterns = {"/addcontact"})
public class AddContact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //chuyển sang trang jsp
        request.getRequestDispatcher("view/admin/addcontact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //get data from jsp to severlet
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String oppentime = request.getParameter("oppentime");

        // truyen sang dao
        Contact contact = new Contact();
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setOpenTime(oppentime);
        contact.setEmail(email);
        // thêm 1 contact vào database
        ContactDAO dao = new ContactDAO();
        dao.insert(contact);
        response.sendRedirect("listcontact");
    }

}
