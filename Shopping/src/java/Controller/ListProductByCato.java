/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.ProductDAO;
import DAO.SocialDAO;
import Model.Catogory;
import Model.Contact;
import Model.Product;
import Model.Social;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ListProductByCato", urlPatterns = {"/listProductByCato"})
public class ListProductByCato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //get index
            String pageIndex = request.getParameter("index");
            //convert string to int
            int id = Integer.parseInt(request.getParameter("did"));
            if (pageIndex == null) {//if null for index = 1
                pageIndex = "1";
            }
            // convert to int
            int index = Integer.parseInt(pageIndex);
            //get data
            ProductDAO proDao = new ProductDAO();
            int total = proDao.countProductByCato(id);//all product by cate
            int pageSize = 8;// sizepage
            int maxPage = (total / pageSize);// tổng page
            if (total % pageSize != 0) {// chia dư khác 0 thì + 1
                maxPage++;
            }
            //get category
            CatogoryDAO cato = new CatogoryDAO();
            List<Catogory> listCato = cato.getListCato();
            List<Catogory> listCato2 = cato.getListCatoFrom4();
            //get product
            List<Product> listPro1 = proDao.getProductByCato1(1);
            List<Product> listPro2 = proDao.getProductByCato1(2);
            List<Product> listPro3 = proDao.getProductByCato1(3);
            //get social
            SocialDAO SociDao = new SocialDAO();
            List<Social> social = SociDao.getListSocaial();
            //get contact
            ContactDAO ContactDAO = new ContactDAO();
            Contact contact = ContactDAO.getConById(1);
            //set data to jsp
            request.setAttribute("maxPage", maxPage);// maxpage
            request.setAttribute("index", index);//index
            request.setAttribute("social", social);// list social header
            request.setAttribute("contact", contact);//contact footer
            request.setAttribute("listCato", listCato); // list catelog all
            request.setAttribute("listCato2", listCato2);//list catelog chính

            request.setAttribute("listPro1", listPro1);//mới
            request.setAttribute("listPro2", listPro2);// pro sếp hanh cao
            request.setAttribute("listPro3", listPro3);// pro bán chạy
            //get cate by id
            Catogory catogory = cato.getCatoById(id);
            request.setAttribute("ct", catogory);
            //list product by cate
            List<Product> listPro = proDao.getProductByCato(id, index, pageSize);
            request.setAttribute("listPro", listPro);//list product by cate
            //chuyen sang jsp
            request.getRequestDispatcher("/ListProductByCatoHome.jsp").forward(request, response);

        } catch (NumberFormatException | IOException | ServletException e) {
            request.setAttribute("error", "Can not data");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
