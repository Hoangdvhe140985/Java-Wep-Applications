/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Review;
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
public class ReviewDAO extends DBContext {
    
    public void insert(Review review) {
        
        String sql = "INSERT INTO review(product_id,  name, "
                + "email, content, created) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, review.getProduct_id());
            ps.setString(2, review.getName());
            ps.setString(3, review.getEmail());
            ps.setString(4, review.getContent());
            ps.setString(5, review.getCreated());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM review WHERE id=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Review> getAll() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getString("id"));
                review.setName(rs.getString("name"));
                review.setEmail(rs.getString("email"));
                review.setProduct_id(rs.getString("product_id"));
                review.setContent(rs.getString("content"));
                review.setCreated(rs.getString("created"));
                reviews.add(review);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    }
    
    public List<Review> getReviewById(int id) {
        
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE product_id=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Review review = new Review();
                review.setId(rs.getString("id"));
                review.setName(rs.getString("name"));
                review.setEmail(rs.getString("email"));
                review.setProduct_id(rs.getString("product_id"));
                review.setContent(rs.getString("content"));
                review.setCreated(rs.getString("created"));
                reviews.add(review);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    }
    
    public static void main(String[] args) {
        ReviewDAO u = new ReviewDAO();
//        String id = "100";
//
//        String name = "hoang";
//        String email = "dvhoang199x@gmail.com";
//        String content = "An toàn, sạch sẽ!";
//        long millis = System.currentTimeMillis();
//        java.sql.Date date = new java.sql.Date(millis);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String today = df.format(date);
//
//        Review review = new Review();
//        review.setName(name);
//        review.setEmail(email);
//        review.setProduct_id(id);
//        review.setContent(content);
//        review.setCreated(today);       
//        ReviewDAO dao = new ReviewDAO();
//        dao.insert(review);
        
    //    u.getReviewById(100).forEach(System.out::println);
//        System.out.println(u.getUserByID(100000));
    }
}
