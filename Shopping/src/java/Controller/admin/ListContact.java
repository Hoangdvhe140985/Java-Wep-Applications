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
@WebServlet(name = "ListContact", urlPatterns = {"/listcontact"})
public class ListContact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        ContactDAO dao = new ContactDAO();
        List<Contact> users = dao.getListContact();
        //truyen data tu sevelet to jsp 
        request.setAttribute("contactlist", users);
        request.getRequestDispatcher("view/admin/show-contact.jsp").forward(request, response);
    }

}
