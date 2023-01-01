/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.ProductDAO;
import DAO.SocialDAO;
import Model.Catogory;
import Model.Contact;
import Model.Product;
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
@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get data
        try {
            String pageIndex = request.getParameter("index");
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            ProductDAO proDao = new ProductDAO();
            int total = proDao.countAllProduct();
            int pageSize = 6;
            int maxPage = (total / pageSize);
            if (total % pageSize != 0) {
                maxPage++;
            }
            //get all product by page
            List<Product> listPro = proDao.getAllProductByPage(index, pageSize);
            //get category
            CatogoryDAO cato = new CatogoryDAO();
            List<Catogory> listCato = cato.getListCato();
            List<Catogory> listCato2 = cato.getListCatoFrom4();
            //get list product
            List<Product> listPro1 = proDao.getProductByCato1(1);
            List<Product> listPro2 = proDao.getProductByCato1(2);
            List<Product> listPro3 = proDao.getProductByCato1(3);
            //get list social 
            SocialDAO SociDao = new SocialDAO();
            List<Social> social = SociDao.getListSocaial();
            //get contact
            ContactDAO ContactDAO = new ContactDAO();
            Contact contact = ContactDAO.getConById(1);

            //set data to jsp
            request.setAttribute("social", social);
            request.setAttribute("contact", contact);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("index", index);
            request.setAttribute("listPro", listPro);
            request.setAttribute("listCato", listCato);
            request.setAttribute("listCato2", listCato2);
            request.setAttribute("total", total);
            request.setAttribute("listPro1", listPro1);
            request.setAttribute("listPro2", listPro2);
            request.setAttribute("listPro3", listPro3);

            //chuyen sang jsp
            request.getRequestDispatcher("Shop.jsp").forward(request, response);
        } catch (NumberFormatException | IOException | ServletException e) {
            request.setAttribute("error", "Can not data");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
