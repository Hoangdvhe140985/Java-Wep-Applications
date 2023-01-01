/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Social;
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
public class SocialDAO extends DBContext {

    //get list  
    public List<Social> getListSocaial() {
        List<Social> social = new ArrayList<>();
        try {
            String sql = "SELECT idSocial,UrlSocial,logo FROM Social";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Social s = new Social();
                s.setId(rs.getInt("idSocial"));
                s.setUrl(rs.getString("UrlSocial"));
                s.setLogo(rs.getString("logo"));
                social.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return social;
    }

    //get social by id
    public Social getSocialById(int id) {
        try {
            String sql = "SELECT idSocial,UrlSocial FROM Social WHERE idSocial = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Social S = new Social();
                S.setId(rs.getInt("idSocial"));
                S.setUrl(rs.getString("UrlSocial"));
                return S;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //delete social
    public void delete(int id) {
        String sql = "DELETE FROM Social WHERE idSocial = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update social
    public void update(Social social) {
        try {
            String sql = "UPDATE Social SET UrlSocial = ? WHERE idSocial = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, social.getId());
            stm.setString(1, social.getUrl());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add social
    public void insert(Social social) {
        try {
            String sql = "INSERT INTO Social(UrlSocial) VALUES(?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, social.getUrl());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //test method
    public static void main(String[] args) {
        SocialDAO ca = new SocialDAO();
//        ca.getListCato().forEach(System.out::println);
//        System.out.print(ca.getCatoById(2));
    }

}
