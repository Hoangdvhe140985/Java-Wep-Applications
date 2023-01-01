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
public class RegisterDAO extends DBContext {

    public boolean register(User user) {
        int row = 0;
        String sql = "INSERT INTO Users (UserName,Pass,Names,Gerder,Address,Email,Phone,Role) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUserName());
            stm.setString(2, user.getPass());
            stm.setString(3, user.getNames());
            stm.setBoolean(4, user.isGender());
            stm.setString(5, user.getAddress());
            stm.setString(6, user.getEmail());
            stm.setString(7, user.getPhone());
            stm.setInt(8, user.getRole());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row > 0;
    }

    public boolean checkAccountExist(String username) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Users WHERE UserName LIKE ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count > 0;
    }
}
