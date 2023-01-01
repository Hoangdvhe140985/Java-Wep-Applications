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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "EditCatogory", urlPatterns = {"/editcatogory"})
public class EditCatogory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id cate from jsp to sever
        int id = Integer.parseInt(request.getParameter("cid"));
        // truyen cid to dao
        CatogoryDAO dao = new CatogoryDAO();
        Catogory cato = dao.getCatoById(id);

        //truyen data tu sevelet to jsp 
        request.setAttribute("cate", cato);
        request.getRequestDispatcher("view/admin/editcate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server 
        int cate_id = Integer.parseInt(request.getParameter("idCato"));
        String cate_name = request.getParameter("nameCato");
        
        //set data
        Catogory cate = new Catogory();
        cate.setNameCato(cate_name);
        cate.setIdCato(cate_id);
        
        //update data
        CatogoryDAO dao = new CatogoryDAO();
        dao.update(cate);
        //chuyen huong sang list cate
        response.sendRedirect("listcatogory");
    }

}
