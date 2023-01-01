/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.SocialDAO;
import Model.Catogory;
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
@WebServlet(name = "ContactClient", urlPatterns = {"/contactclient"})
public class ContactClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        ContactDAO dao = new ContactDAO();
        List<Contact> contactlist = dao.getListContact();
        CatogoryDAO cato = new CatogoryDAO();
        List<Catogory> listCato = cato.getListCato();
        SocialDAO SociDao = new SocialDAO();
        List<Social> social = SociDao.getListSocaial();
        ContactDAO ContactDAO = new ContactDAO();
        Contact contact = ContactDAO.getConById(1);

        //set data
        request.setAttribute("social", social);
        request.setAttribute("contact", contact);
        request.setAttribute("listCato", listCato);
        request.setAttribute("contactlist", contactlist);
        
        //truyen data tu sevelet to jsp 
        request.getRequestDispatcher("Contact.jsp").forward(request, response);
    }

}
