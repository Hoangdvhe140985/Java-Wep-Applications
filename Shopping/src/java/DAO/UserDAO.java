/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
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
public class UserDAO extends DBContext{
    
    //get all user 
    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("UserName"));
                u.setPass(rs.getString("Pass"));
                u.setNames(rs.getString("Names"));
                u.setGender(rs.getBoolean("Gerder"));                
                u.setAddress(rs.getString("Address"));
                u.setEmail(rs.getString("Email"));
                u.setPhone(rs.getString("Phone"));
                u.setRole(rs.getInt("Role"));                
                user.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    //get user by id   
    public User getUserByID(int id) {
        try {
            String sql = "SELECT * FROM Users WHERE idUser = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("UserName"));
                u.setPass(rs.getString("Pass"));
                u.setNames(rs.getString("Names"));
                u.setGender(rs.getBoolean("Gerder"));                
                u.setAddress(rs.getString("Address"));
                u.setEmail(rs.getString("Email"));
                u.setPhone(rs.getString("Phone"));
                u.setRole(rs.getInt("Role"));  
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //delete user
    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE idUser = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //update user
    public void update(User user) {
        try {
            String sql = "UPDATE Users SET UserName=?,Pass=?,Names=?,"
                    + "Address=?,Email=?,Phone=?,Role=? WHERE idUser = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(8, user.getIdUser());
            stm.setString(1, user.getUserName());
            stm.setString(2, user.getPass());
            stm.setString(3, user.getNames());
            stm.setString(4, user.getAddress());
            stm.setString(5, user.getEmail());
            stm.setString(6, user.getPhone());
            stm.setInt(7, user.getRole());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //test
    public static void main(String[] args) {
        UserDAO u = new UserDAO();
       
//        u.getAllUser().forEach(System.out::println);
//        System.out.println(u.getUserByID(100000));
     
    }
}
