/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Catogory;
import DAO.CatogoryDAO;

/**
 *
 * @author hoang
 */
@WebServlet(name = "AddCatogory", urlPatterns = {"/addcatogory"})
public class AddCatogory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //chuyển sang trang jsp
        request.getRequestDispatcher("view/admin/addcate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // chánh lỗi font tiếng việt
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //get data from jsp to severlet
        String cate_name = request.getParameter("cate-name");
        // truyen sang dao
        Catogory cate = new Catogory();
        cate.setNameCato(cate_name);
        CatogoryDAO dao = new CatogoryDAO();
        // thêm 1 catelog vào database
        dao.insert(cate);
        response.sendRedirect("listcatogory");
    }

}
