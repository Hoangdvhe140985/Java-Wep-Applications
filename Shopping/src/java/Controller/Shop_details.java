/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.ProductDAO;
import DAO.ReviewDAO;
import DAO.SocialDAO;
import Model.Catogory;
import Model.Contact;
import Model.Product;
import Model.Review;
import Model.Social;
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
@WebServlet(name = "Shop_details", urlPatterns = {"/shopdetails"})
public class Shop_details extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get id product
        String id = request.getParameter("id");
        //get product by id
        ProductDAO proDao = new ProductDAO();
        Product pro = proDao.getProductById(Integer.parseInt(id));
        //get list product new
        List<Product> listPro1 = proDao.getProductByCato1(1);
        CatogoryDAO cato = new CatogoryDAO();
        //get list category all
        List<Catogory> listCato = cato.getListCato();
        //get list review
        ReviewDAO reviewDAO = new ReviewDAO();
        List<Review> listReview = reviewDAO.getReviewById(Integer.parseInt(id));
        //get social
        SocialDAO SociDao = new SocialDAO();
        List<Social> social = SociDao.getListSocaial();
        //get contact
        ContactDAO ContactDAO = new ContactDAO();
        Contact contact = ContactDAO.getConById(1);

        //set data to jsp
        request.setAttribute("listCato", listCato);//list all cate
        request.setAttribute("listReview", listReview);//list review product
        request.setAttribute("social", social);//list social
        request.setAttribute("contact", contact);// contact footer
        request.setAttribute("product", pro);// product-detail
        request.setAttribute("listPro1", listPro1);// list product new
        //chuyen data to jsp
        request.getRequestDispatcher("Shop-details.jsp").forward(request, response);

    }

}
