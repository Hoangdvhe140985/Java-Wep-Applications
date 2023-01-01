/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ProductDAO;
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
@WebServlet(name = "ListProductAdmin", urlPatterns = {"/listproductadmin"})
public class ListProductAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data
        ProductDAO dao = new ProductDAO();
        List<Product> listPro = dao.getAllProduct();
        //set data to jsp            
        request.setAttribute("listproduct", listPro);
        request.getRequestDispatcher("view/admin/show-product.jsp").forward(request, response);

    }

}
