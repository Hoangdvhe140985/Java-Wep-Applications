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
@WebServlet(name = "EditProduct", urlPatterns = {"/editproduct"})
public class EditProduct extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id user from jsp
        int id = Integer.parseInt(request.getParameter("pid"));
        // truyen uid to dao
        ProductDAO dao = new ProductDAO();
        Product u = dao.getProductById(id);
        CatogoryDAO cato = new CatogoryDAO();
        List<Catogory> listCato = cato.getListCato();
        //truyen data tu sevelet to jsp 
        request.setAttribute("product", u);
        request.setAttribute("listCato", listCato);
        request.getRequestDispatcher("view/admin/editproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server 
        int id = Integer.parseInt(request.getParameter("id"));
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

        //set data
        Product p = new Product();
        p.setIdProduct(id);
        p.setNamePro(name);
        p.setIdCato(c);
        p.setPrice(price);
        p.setQuantity(quatity);
        p.setSale(discount);
        p.setDescriptionCT(content);
        p.setDescriptionN(descn);
        p.setImgUrl(img);
        p.setWeigh(weigh);
        
        //update data
        ProductDAO dao = new ProductDAO();
        dao.update(p);
        //chuyen huong sang list user
        response.sendRedirect("listproductadmin");
    }

}
