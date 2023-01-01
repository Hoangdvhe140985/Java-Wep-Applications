/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.TransactionDao;
import Model.Transactions;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "EditTransactions", urlPatterns = {"/edittransactions"})
public class EditTransactions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id user from jsp
        int id = Integer.parseInt(request.getParameter("id"));
        // truyen uid to dao
        TransactionDao dao = new TransactionDao();
        Transactions t = dao.getTransactionsById(id);
        //truyen data tu sevelet to jsp 
        request.setAttribute("transaction", t);
        request.getRequestDispatcher("view/admin/editorder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //lấy và gửi dữ liệu utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //lấy data tu client lên server and set data
        Transactions transactions = new Transactions();
        transactions.setId(Integer.parseInt(request.getParameter("order-id")));
        transactions.setUser_name(request.getParameter("order-name"));
        transactions.setUser_mail(request.getParameter("order-mail"));
        transactions.setUser_phone(request.getParameter("order-phone"));
        transactions.setAddress(request.getParameter("order-address"));
        transactions.setMessage(request.getParameter("order-mess"));
        transactions.setAmount(request.getParameter("order-amount"));
        transactions.setPayment(request.getParameter("order-payment"));
        transactions.setStatus(request.getParameter("order-status"));

        //update data
        TransactionDao dao = new TransactionDao();
        dao.update(transactions);
        //chuyen huong sang list user
        response.sendRedirect("listorderdetail");
    }

}
