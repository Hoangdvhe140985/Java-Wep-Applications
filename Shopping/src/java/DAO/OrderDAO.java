/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ordered;
import Utils.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class OrderDAO extends DBContext {

    //list order
    public List<Ordered> getListOrdered() {
        List<Ordered> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Orders";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Ordered order = new Ordered();
                order.setId(rs.getString("idOrder"));
                order.setProduct_id(rs.getString("idPro"));
                order.setTransacsion_id(rs.getString("idTransac"));
                order.setQty((rs.getInt("quantity")));
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    //delete order
    
    //add order
    public void insert(Ordered order) {
        try {
            String sql = "INSERT INTO Orders(idPro, idTransac , quantity) VALUES (?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(order.getProduct_id()));
            stm.setInt(2, Integer.parseInt(order.getTransaction_id()));
            stm.setInt(3, order.getQty());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
