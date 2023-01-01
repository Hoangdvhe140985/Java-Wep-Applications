/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Model.Item;
import Model.Order;
import Model.Product;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
@WebServlet(name = "AddCartController", urlPatterns = {"/addcart"})
public class AddCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int n = 0;
        //mặc định add vào giỏ hàng là 1
        int qty = 1;
        //lấy id của sản phẩm
        String id = request.getParameter("product-id");
        // formart cho giá tiền 
        DecimalFormat df = new DecimalFormat("#.000");
        // nếu id sảm phẩm tồn tại thì tiếp tục mua hàng
        if (request.getParameter("product-id") != null) {

            ProductDAO prodao = new ProductDAO();
            Product product = prodao.getProductById(Integer.parseInt(id));
            if (product != null) {
                if (request.getParameter("qty") != null) {
                    qty = Integer.parseInt(request.getParameter("qty"));
                }
                // tạo 1 cái session
                HttpSession session = request.getSession();
                // sau đó test nếu bằng null thì giỏ hàng chưa tồn tại
                if (session.getAttribute("order") == null) {
                    //tạo giỏ hàng
                    Order order = new Order();
                    //tạo list sản phảm order 
                    List<Item> listItems = new ArrayList<>();
                    Item item = new Item();
                    item.setQty(qty);// set số lượng chính bằng 1
                    item.setProduct(product);// set sản phẩm 
                    item.setPrice(product.getPrice() - (product.getPrice() * product.getSale() / 100));// set pice tính discort nếu có
                    order.setSumPrice(0);// tính tổng các item vì 1 order có thể có nhiều list item
                    order.setSumPrice(order.getSumPrice() + item.getPrice());
                    listItems.add(item);//add vào list item
                    order.setItems(listItems);//set vào order
                    n = listItems.size();// n là số sản phẩm
                    session.setAttribute("length_order", n);
                    session.setAttribute("order", order);//lưu order vào session với key là order
                    session.setAttribute("sumprice", df.format(order.getSumPrice()));
                } else {
                    // nếu order đã tồn tại lấy order từ session ra
                    Order order = (Order) session.getAttribute("order");
                    // lấy list item
                    List<Item> listItems = order.getItems();
                    // check 
                    boolean check = false;
                    //lọc list item nếu id sản phẩm bằng id sản phảm mới thêm vào
                    for (Item item : listItems) {
                        //nếu bằng thì cộng số lượng lên 1
                        if (item.getProduct().getIdProduct() == product.getIdProduct()) {
                            item.setQty(item.getQty() + qty);
                            order.setSumPrice(order.getSumPrice() + item.getProduct().getPrice() - item.getProduct().getPrice() * (item.getProduct().getSale() / 100));
                            item.setPrice(item.getPrice() + (item.getProduct().getPrice() - item.getProduct().getPrice() * (item.getProduct().getSale() / 100)));
                            check = true;// vì đã có rồi đổi thành true để k tiếp tục add nữa
                        }
                    }
                    if (check == false) {// chưa có thì thêm mới item
                        Item item = new Item();
                        item.setQty(qty);
                        item.setProduct(product);
                        item.setPrice(product.getPrice() - item.getProduct().getPrice() * (item.getProduct().getSale() / 100));
                        order.setSumPrice(order.getSumPrice() + item.getProduct().getPrice() - item.getProduct().getPrice() * (item.getProduct().getSale() / 100));
                        listItems.add(item);// add vào list item
                    }
                    // cập nhật lại các đối tượng
                    n = listItems.size();
                    session.setAttribute("length_order", n);
                    session.setAttribute("order", order);
                    session.setAttribute("sumprice", df.format(order.getSumPrice()));
                }
            }
            // trả về shop sau khi add để tiếp tục mua sắm
            response.sendRedirect("shop");
        } else {
            response.sendRedirect("/");
        }
    }

}
