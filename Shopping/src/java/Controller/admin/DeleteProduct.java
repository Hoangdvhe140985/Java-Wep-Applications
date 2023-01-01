/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "DeleteProduct", urlPatterns = {"/deleteproduct"})
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id product from jsp to severt
        int id = Integer.parseInt(request.getParameter("pid"));
        // delete a product
        ProductDAO dao = new ProductDAO();
        dao.deleteProduct(id);
        //chuyen huong sang list user(tra ket qua vè list)
        response.sendRedirect("listproductadmin");
    }

}
