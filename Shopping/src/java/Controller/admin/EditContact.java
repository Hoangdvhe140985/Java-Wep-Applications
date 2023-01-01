/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ContactDAO;
import Model.Contact;
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
@WebServlet(name = "EditContact", urlPatterns = {"/editcontact"})
public class EditContact extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id user from jsp
        int id = Integer.parseInt(request.getParameter("cid"));
        // truyen uid to dao
        ContactDAO dao = new ContactDAO();
        Contact c = dao.getConById(id);
        //truyen data tu sevelet to jsp 
        request.setAttribute("contact", c);
        request.getRequestDispatcher("view/admin/editcontact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //lấy data tu client lên server 
        int id = Integer.parseInt(request.getParameter("idcontact"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String oppentime = request.getParameter("oppentime");

        //set data 
        Contact contact = new Contact();
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setOpenTime(oppentime);
        contact.setEmail(email);
        contact.setIdContact(id);
        
        //update data
        ContactDAO dao = new ContactDAO();
        dao.update(contact);
        //chuyen huong sang list user
        response.sendRedirect("listcontact");
    }

}
