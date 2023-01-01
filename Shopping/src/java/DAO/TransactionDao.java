/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Transactions;
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
public class TransactionDao extends DBContext {

    //update order
    public void update(Transactions transaction) {
        try {
            String sql = "Update transactions set user_name =?, user_mail =?, user_phone =?, "
                    + "address= ?,message=?,amount=?,payment=?, status=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transaction.getUser_name());
            ps.setString(2, transaction.getUser_mail());
            ps.setString(3, transaction.getUser_phone());
            ps.setString(4, transaction.getAddress());
            ps.setString(5, transaction.getMessage());
            ps.setString(6, transaction.getAmount());
            ps.setString(7, transaction.getPayment());
            ps.setString(8, transaction.getStatus());
            ps.setInt(9, transaction.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //get order by id
    public Transactions getTransactionsById(int id) {
        try {
            String sql = "SELECT * FROM transactions WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
                transaction.setUser_session(rs.getString("user_session"));
                transaction.setUser_name(rs.getString("user_name"));
                transaction.setUser_mail(rs.getString("user_mail"));
                transaction.setUser_phone(rs.getString("user_phone"));
                transaction.setAddress(rs.getString("address"));
                transaction.setMessage(rs.getString("message"));
                transaction.setAmount(rs.getString("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setCreated(rs.getString("created"));
                return transaction;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //add transac
    public void insert(Transactions transaction) {
        String sql = "INSERT INTO transactions(user_session,user_name,user_mail,user_phone,"
                + "address,message,amount,payment,status,created) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transaction.getUser_session());
            ps.setString(2, transaction.getUser_name());
            ps.setString(3, transaction.getUser_mail());
            ps.setString(4, transaction.getUser_phone());
            ps.setString(5, transaction.getAddress());
            ps.setString(6, transaction.getMessage());
            ps.setString(7, transaction.getAmount());
            ps.setString(8, transaction.getPayment());
            ps.setString(9, transaction.getStatus());
            ps.setString(10, transaction.getCreated());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TransactionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //list order
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = new ArrayList<>();
        try {
            String sql = "SELECT * FROM transactions";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
                transaction.setUser_session(rs.getString("user_session"));
                transaction.setUser_name(rs.getString("user_name"));
                transaction.setUser_mail(rs.getString("user_mail"));
                transaction.setUser_phone(rs.getString("user_phone"));
                transaction.setAddress(rs.getString("address"));
                transaction.setMessage(rs.getString("message"));
                transaction.setAmount(rs.getString("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setStatus(rs.getString("status"));
                transaction.setCreated(rs.getString("created"));
                transactions.add(transaction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactions;
    }

//test method
    public static void main(String[] args) {
        TransactionDao ca = new TransactionDao();
//        String tr_usersession = "chuoi";
//        String tr_username = "hoang";
//        String tr_usermail = "dvhoang199x@gmail.com";
//        String tr_userphone = "0974089738";
//        String tr_useraddress = "Ha Noi";
//        String tr_usermess = "Nhanh";
//        String tr_amount = "200";
//        String tr_payment = "Thanh Toán Khi Nhận";
//        String tr_ship = "Chưa Ship";
//      //  String tr_created = "2022-02-22";
//        
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date today = Calendar.getInstance().getTime();
//        String date = df.format(today);
//        
//        Transactions transaction = new Transactions();
//        
//        transaction.setUser_session(tr_usersession);
//        transaction.setUser_name(tr_username);
//        transaction.setUser_mail(tr_usermail);
//        transaction.setUser_phone(tr_userphone);
//        transaction.setAddress(tr_useraddress);
//        transaction.setMessage(tr_usermess);
//        transaction.setAmount(tr_amount);
//        transaction.setPayment(tr_payment);
//        transaction.setStatus(tr_ship);
//        transaction.setCreated(date);
//        
//        ca.insert(transaction);
        ca.getAllTransactions().forEach(System.out::println);
//        System.out.print(ca.getCatoById(2));
    }
}
