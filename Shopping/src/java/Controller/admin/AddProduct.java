/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.CatogoryDAO;
import DAO.ProductDAO;
import Model.Catogory;
import Model.Product;
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
@WebServlet(name = "AddProduct", urlPatterns = {"/addproduct"})
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get data list catelog from DAO
        CatogoryDAO cato = new CatogoryDAO();
        List<Catogory> listCato = cato.getListCato();
        //truyen data tu sevelet to jsp        
        request.setAttribute("listCato", listCato);
        //chuyển sang trang jsp
        request.getRequestDispatcher("view/admin/addproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server     
        String name = request.getParameter("name");
        Catogory c = new Catogory();
        c.setIdCato(Integer.parseInt(request.getParameter("idCate")));
        float price = Float.parseFloat(request.getParameter("price"));
        int quatity = Integer.parseInt(request.getParameter("quatity"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        String descn = request.getParameter("descn");
        String content = request.getParameter("content");
        String img = request.getParameter("img");
        int weigh = Integer.parseInt(request.getParameter("weigh"));

        // set data
        Product p = new Product();     
        p.setNamePro(name);
        p.setIdCato(c);
        p.setPrice(price);
        p.setQuantity(quatity);
        p.setSale(discount);
        p.setDescriptionCT(content);
        p.setDescriptionN(descn);
        p.setImgUrl(img);
        p.setWeigh(weigh);
        //ínert data to database
        ProductDAO dao = new ProductDAO();
        dao.insert(p);
        //chuyen huong sang list user
        response.sendRedirect("listproductadmin");
    }

}
