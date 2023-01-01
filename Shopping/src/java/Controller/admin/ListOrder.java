/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Ordered;
import Model.Product;
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
@WebServlet(name = "ListOrder", urlPatterns = {"/listorder"})
public class ListOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        OrderDAO dao = new OrderDAO();
        List<Ordered> order = dao.getListOrdered();
        //truyen data tu sevelet to jsp 
        request.setAttribute("listorder", order);

        //get data
        ProductDAO prodao = new ProductDAO();
        List<Product> listPro = prodao.getAllProduct();
        //set data to jsp            
        request.setAttribute("listproduct", listPro);

        request.getRequestDispatcher("view/admin/show-order.jsp").forward(request, response);
    }

}
