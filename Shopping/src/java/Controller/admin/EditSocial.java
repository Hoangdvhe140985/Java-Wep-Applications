/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.SocialDAO;
import Model.Social;
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
@WebServlet(name = "EditSocial", urlPatterns = {"/editsocial"})
public class EditSocial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id cate from jsp
        int id = Integer.parseInt(request.getParameter("sid"));
        // truyen cid to dao
        SocialDAO dao = new SocialDAO();
        Social social = dao.getSocialById(id);
        //truyen data tu sevelet to jsp 
        request.setAttribute("social", social);
        request.getRequestDispatcher("view/admin/editsocial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server 
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        Social social = new Social();
        social.setUrl(url);
        social.setId(id);
        
        //update data
        SocialDAO dao = new SocialDAO();
        dao.update(social);
        //chuyen huong sang list cate
        response.sendRedirect("listsocial");
    }

}
