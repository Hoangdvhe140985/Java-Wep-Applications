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
@WebServlet(name = "ListProduct", urlPatterns = {"/listproduct"})
public class ListProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data
        try {
            //get data from client to server
            String pageIndex = request.getParameter("index");
            if (pageIndex == null) {//if null set = 1
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);// convert to int

            ProductDAO proDao = new ProductDAO();
            int total = proDao.countAllProduct();//get count all product
            int pageSize = 8;//size page = 8
            int maxPage = (total / pageSize);// max = total/8
            if (total % pageSize != 0) { // nếu chia dư khác 0 thì + 1
                maxPage++;
            }
            //get all product
            List<Product> listPro = proDao.getAllProductByPage(index, pageSize);
            //get category 
            CatogoryDAO cato = new CatogoryDAO();
            List<Catogory> listCato = cato.getListCato();//all
            List<Catogory> listCato2 = cato.getListCatoFrom4();//cate chính

            List<Product> listPro1 = proDao.getProductByCato1(1);// bán chạy
            List<Product> listPro2 = proDao.getProductByCato1(2);// mới
            List<Product> listPro3 = proDao.getProductByCato1(3);// ...

            //get social for header
            SocialDAO SociDao = new SocialDAO();
            List<Social> social = SociDao.getListSocaial();

            //get contact for foooter
            ContactDAO ContactDAO = new ContactDAO();
            Contact contact = ContactDAO.getConById(1);

            //get data chuyen sang jsp
            request.setAttribute("social", social);//social
            request.setAttribute("contact", contact);//contact
            request.setAttribute("maxPage", maxPage);// size page max
            request.setAttribute("index", index); // page
            request.setAttribute("listPro", listPro); //list all product
            request.setAttribute("listCato", listCato); // list all catalog
            request.setAttribute("listCato2", listCato2);// list catalog chính
            request.setAttribute("listPro1", listPro1);//product mới
            request.setAttribute("listPro2", listPro2);//product sếp hang cao
            request.setAttribute("listPro3", listPro3);//product bán chạy
            
            //chuyen sang trang index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException | IOException | ServletException e) {
            request.setAttribute("error", "Can not data");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
