/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CatogoryDAO;
import DAO.ContactDAO;
import DAO.SocialDAO;
import Model.Catogory;
import Model.Contact;
import Model.Item;
import Model.Order;
import Model.Social;
import java.io.IOException;
import java.text.DecimalFormat;
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
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get list category 
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
        //chuyen sang jsp
        request.getRequestDispatcher("Cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //khởi tạo session
        HttpSession session = request.getSession();
        //lấy order từ session ra
        Order order = (Order) session.getAttribute("order");
        //lấy list item
        List<Item> listItems = order.getItems();
        //set tổng price order
        order.setSumPrice(0);
        //lọc list item
        for (Item item : listItems) {
            // get qty product
            String qty = String.valueOf(item.getProduct().getIdProduct());
            item.setQty(Integer.parseInt(request.getParameter(qty)));
            //tính giá tiền
            item.setPrice((item.getProduct().getPrice() - item.getProduct().getPrice() * (item.getProduct().getSale() / 100)) * Double.parseDouble(request.getParameter(qty)));
            order.setSumPrice(order.getSumPrice() + item.getPrice());
        }
        order.setItems(listItems);
        session.setAttribute("order", order);
        session.setAttribute("sumprice", df.format(order.getSumPrice()));
        response.sendRedirect("cart");
    }

}
