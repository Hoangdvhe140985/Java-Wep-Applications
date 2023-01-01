/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.CatogoryDAO;
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
@WebServlet(name = "DeleteCaogory", urlPatterns = {"/deletecatogory"})
public class DeleteCatogory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id cate from jsp to server
        int id = Integer.parseInt(request.getParameter("cid"));
        // delete a catelog
        CatogoryDAO dao = new CatogoryDAO();
        dao.deleteCato(id);
        //chả kết quả về list user
        response.sendRedirect("listcatogory");
    }

}
