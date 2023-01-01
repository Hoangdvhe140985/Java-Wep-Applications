/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.OrderDAO;
import DAO.SocialDAO;
import DAO.TransactionDao;
import Model.Catogory;
import Model.Contact;
import Model.Item;
import Model.Order;
import Model.Ordered;
import Model.Social;
import Model.Transactions;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoang
 */
@WebServlet(name = "TransactionController", urlPatterns = {"/transaction"})
public class TransactionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get list cate
        CatogoryDAO cato = new CatogoryDAO();
        List<Catogory> listCato = cato.getListCato();
        //get list social
        SocialDAO SociDao = new SocialDAO();
        List<Social> social = SociDao.getListSocaial();
        //get contact
        ContactDAO ContactDAO = new ContactDAO();
        Contact contact = ContactDAO.getConById(1);
        
        //set data
        request.setAttribute("listCato", listCato);
        request.setAttribute("social", social);
        request.setAttribute("contact", contact);
        //chuyen data sang trang jsp
        request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //lấy data tu client lên server
        String tr_usersession = request.getParameter("transaction_usersession");
        String tr_username = request.getParameter("transaction_name");
        String tr_usermail = request.getParameter("transaction_email");
        String tr_userphone = request.getParameter("transaction_phone");
        String tr_useraddress = request.getParameter("transaction_address");
        String tr_usermess = request.getParameter("transaction_mess");
        String tr_amount = request.getParameter("transaction_amount");
        String tr_payment = request.getParameter("transaction_payment");
        String tr_ship = "Chưa Ship";
        String tr_created = request.getParameter("transaction_created");

        //set data
        Transactions transaction = new Transactions();
        transaction.setUser_session(tr_usersession);
        transaction.setUser_name(tr_username);
        transaction.setUser_mail(tr_usermail);
        transaction.setUser_phone(tr_userphone);
        transaction.setAddress(tr_useraddress);
        transaction.setMessage(tr_usermess);
        transaction.setAmount(tr_amount);
        transaction.setPayment(tr_payment);
        transaction.setStatus(tr_ship);
        transaction.setCreated(tr_created);
        
        //insert data to database
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.insert(transaction);

        int maxid = 0;//gán id lớn nhất = 0
        //get list giao dịch
        List<Transactions> transactions = transactionDao.getAllTransactions();
        if (transactions.isEmpty()) {//trống thì = 0
            maxid = 0;
        } else {
            //duyệt list lấy id lớn nhất
            for (Transactions transactions2 : transactions) {
                if (transactions2.getId() >= maxid) {
                    maxid = transactions2.getId();
                }
            }
        }
        //check session
        HttpSession session = request.getSession(true);
        Order order = (Order) session.getAttribute("order");
        //get list item
        List<Item> listItems = order.getItems();
        //duyệt list item
        for (Item item : listItems) {
            //get and set data list item
            Ordered ordered = new Ordered();
            ordered.setProduct_id(String.valueOf(item.getProduct().getIdProduct()));
            ordered.setQty(item.getQty());
            ordered.setTransacsion_id(String.valueOf(maxid));
            //add vao database
            OrderDAO orderDao = new OrderDAO();
            orderDao.insert(ordered);
        }
        if (session != null) {
            session.removeAttribute("order"); //remove session
            session.removeAttribute("sumprice"); //remove session
            session.removeAttribute("length_order"); //remove session
        }
        //tra ve thông tin giao dịch
        response.sendRedirect("transaction");

    }

}
