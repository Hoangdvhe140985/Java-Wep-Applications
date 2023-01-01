/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Catogory;
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
public class CatogoryDAO extends DBContext {

    //get list catogory 
    public List<Catogory> getListCato() {
        List<Catogory> cato = new ArrayList<>();
        try {
            String sql = "SELECT idCato,nameCato FROM Catogory";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Catogory c = new Catogory();
                c.setIdCato(rs.getInt("idCato"));
                c.setNameCato(rs.getString("nameCato"));
                cato.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cato;
    }

    public List<Catogory> getListCatoFrom4() {
        List<Catogory> cato = new ArrayList<>();
        try {
            String sql = "SELECT idCato,nameCato FROM Catogory WHERE idCato NOT IN (1,2,3) ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Catogory c = new Catogory();
                c.setIdCato(rs.getInt("idCato"));
                c.setNameCato(rs.getString("nameCato"));
                cato.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cato;
    }
    
    //get catogory by id
    public Catogory getCatoById(int id) {
        try {
            String sql = "SELECT * FROM Catogory WHERE idCato = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Catogory cato = new Catogory();
                cato.setIdCato(rs.getInt("idCato"));
                cato.setNameCato(rs.getString("nameCato"));
                return cato;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //delete category
    public void deleteCato(int id) {
        String sql = "DELETE FROM Catogory WHERE idCato = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CatogoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update cate
    public void update(Catogory cate) {
        try {
            String sql = "UPDATE Catogory SET nameCato = ? WHERE idCato = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, cate.getIdCato());
            stm.setString(1, cate.getNameCato());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add cate
    public void insert(Catogory cate) {
        try {
            String sql = "INSERT INTO Catogory(nameCato) VALUES(?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cate.getNameCato());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //test method
    public static void main(String[] args) {
        CatogoryDAO ca = new CatogoryDAO();
//        ca.getListCato().forEach(System.out::println);
//        System.out.print(ca.getCatoById(2));
    }
}
