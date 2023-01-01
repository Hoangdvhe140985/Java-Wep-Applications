/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.CatogoryDAO;
import Model.Catogory;
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
@WebServlet(name = "ListCatogory", urlPatterns = {"/listcatogory"})
public class ListCatogory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data tu dao
        CatogoryDAO dao = new CatogoryDAO();
        List<Catogory> cato = dao.getListCato();
        //truyen data tu sevelet to jsp 
        request.setAttribute("catelist", cato);
        request.getRequestDispatcher("view/admin/show-cate.jsp").forward(request, response);
    }

}
