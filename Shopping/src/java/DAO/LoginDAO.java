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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class LoginDAO extends DBContext {

    public User checkLogin(String username, String password) {

        String sql = "SELECT * FROM Users WHERE UserName = ? AND Pass = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("idUser"), rs.getString("UserName"),
                        rs.getString("Pass"), rs.getString("Names"), rs.getBoolean("Gerder"),
                        rs.getString("Address"), rs.getString("Email"), rs.getString("Phone"), rs.getInt("Role"));

                return u;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        LoginDAO u = new LoginDAO();
        System.out.println(u.checkLogin("tao", "123"));
    }
}
