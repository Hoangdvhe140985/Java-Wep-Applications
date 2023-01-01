/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import DAO.TransactionDao;
import Model.Transactions;
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
@WebServlet(name = "ListOrderDetail", urlPatterns = {"/listorderdetail"})
public class ListOrderDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TransactionDao transactionDAO = new TransactionDao();
        List<Transactions> transactionList = transactionDAO.getAllTransactions();
        request.setAttribute("transaction", transactionList);
        request.getRequestDispatcher("view/admin/show-orderdetail.jsp").forward(request, response);
    }

}
