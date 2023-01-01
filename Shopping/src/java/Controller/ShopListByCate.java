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
@WebServlet(name = "ShopListByCate", urlPatterns = {"/shoplistbycate"})
public class ShopListByCate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String pageIndex = request.getParameter("index");
            int id = Integer.parseInt(request.getParameter("did"));
            if (pageIndex == null) {//if pageindex = null gán giá trị =1 
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            ProductDAO proDao = new ProductDAO();
            int total = proDao.countProductByCato(id);//đếm tổng sản phẩm
            int pageSize = 6; //size page = 6
            int maxPage = (total / pageSize);// max page
            if (total % pageSize != 0) {// chia dư khác 0 maxpage + 1
                maxPage++;
            }
            //get cate
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
            request.setAttribute("listCato", listCato);
            request.setAttribute("listCato2", listCato2);
            request.setAttribute("total", total);
            request.setAttribute("listPro1", listPro1);
            request.setAttribute("listPro2", listPro2);
            request.setAttribute("listPro3", listPro3);

            //get cate
            Catogory catogory = cato.getCatoById(id);
            request.setAttribute("ct", catogory);
            //get product by id cate
            List<Product> listPro4 = proDao.getProductByCato(id, index, pageSize);
            request.setAttribute("listPro4", listPro4);//set obj
            //chuyen sang jsp
            request.getRequestDispatcher("/ShopListByCate.jsp").forward(request, response);

        } catch (NumberFormatException | IOException | ServletException e) {
            request.setAttribute("error", "Can not data");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}
