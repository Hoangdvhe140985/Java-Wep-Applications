/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contact;
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
public class ContactDAO extends DBContext {

    //get list contact 
    public List<Contact> getListContact() {
        List<Contact> con = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Contact";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contact c = new Contact();
                c.setIdContact(rs.getInt("idContact"));
                c.setPhone(rs.getString("Phone"));
                c.setAddress(rs.getString("Address"));
                c.setOpenTime(rs.getString("OpenTime"));
                c.setEmail(rs.getString("Email"));
                con.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //get catogory by id
    public Contact getConById(int id) {
        try {
            String sql = "SELECT idContact,Phone,Address,OpenTime,Email FROM Contact WHERE idContact = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Contact c = new Contact();
                c.setIdContact(rs.getInt("idContact"));
                c.setPhone(rs.getString("Phone"));
                c.setAddress(rs.getString("Address"));
                c.setOpenTime(rs.getString("OpenTime"));
                c.setEmail(rs.getString("Email"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //delete contact
    public void deleteContact(int id) {
        String sql = "DELETE FROM Contact WHERE idContact = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update contact
    public void update(Contact contact) {
        try {
            String sql = "UPDATE Contact SET Phone = ? , Address = ? , OpenTime = ? , Email = ? WHERE idContact = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(5, contact.getIdContact());
            stm.setString(1, contact.getPhone());
            stm.setString(2, contact.getAddress());
            stm.setString(3, contact.getOpenTime());
            stm.setString(4, contact.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add cate
    public void insert(Contact contact) {
        try {
            String sql = "INSERT INTO Contact(Phone,Address,OpenTime,Email) VALUES(?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, contact.getPhone());
            stm.setString(2, contact.getAddress());
            stm.setString(3, contact.getOpenTime());
            stm.setString(4, contact.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
