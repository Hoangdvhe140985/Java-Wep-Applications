/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
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
public class ProductDAO extends DBContext {

    //getAllProduct by page
    public List<Product> getAllProductByPage(int index, int pageSize) {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,\n"
                + " idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh,c.nameCato\n"
                + " FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato) AS x WHERE rn BETWEEN ?*?-? AND ?*? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, index);
            stm.setInt(2, pageSize);
            stm.setInt(3, pageSize - 1);
            stm.setInt(4, index);
            stm.setInt(5, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));
                Catogory ca = new Catogory();
                ca.setIdCato(rs.getInt("idCato"));
                ca.setNameCato(rs.getString("nameCato"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                product.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    //get product by catogory and have page  
    public List<Product> getProductByCato(int id, int index, int pageSize) {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,\n"
                + " idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh,c.nameCato\n"
                + " FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE c.idCato LIKE ? ) AS x WHERE rn BETWEEN ?*?-? AND ?*? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, index);
            stm.setInt(3, pageSize);
            stm.setInt(4, pageSize - 1);
            stm.setInt(5, index);
            stm.setInt(6, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));
                Catogory ca = new Catogory();
                ca.setIdCato(rs.getInt("idCato"));
                ca.setNameCato(rs.getString("nameCato"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                product.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    //get product by cate not page
    public List<Product> getProductByCato1(int id) {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,"
                + "Weigh,c.nameCato FROM Product p,Catogory c WHERE p.idCato = c.idCato AND p.idCato = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));
                Catogory ca = new Catogory();
                ca.setIdCato(rs.getInt("idCato"));
                ca.setNameCato(rs.getString("nameCato"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                product.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    //search product name have page
    public List<Product> SearchProduct(String txt, int index, int pageSize) {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY idProduct ASC) AS rn,\n"
                + " idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,Weigh,c.nameCato\n"
                + " FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE namePro LIKE ? ) AS x WHERE rn BETWEEN ?*?-? AND ?*? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            stm.setInt(2, index);
            stm.setInt(3, pageSize);
            stm.setInt(4, pageSize - 1);
            stm.setInt(5, index);
            stm.setInt(6, pageSize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));
                Catogory ca = new Catogory();
                ca.setIdCato(rs.getInt("idCato"));
                ca.setNameCato(rs.getString("nameCato"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                product.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public int countAllProduct() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Product";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int countProductByCato(int idCato) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Product WHERE idCato LIKE ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idCato);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int countProductBySearch(String txt) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Product p INNER JOIN Catogory c ON p.idCato = c.idCato WHERE namePro LIKE ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txt + "%");
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    //get list product
    public List<Product> getAllProduct() {
        List<Product> product = new ArrayList<>();
        String sql = "SELECT idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,"
                + "DescriptionN,DescriptionCT,Weigh,c.nameCato FROM Product p,Catogory c WHERE p.idCato = c.idCato";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));

                Catogory cate = new Catogory();
                cate.setIdCato(rs.getInt("idCato"));
                cate.setNameCato(rs.getString("nameCato"));
                pro.setIdCato(cate);

                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setWeigh(rs.getInt("Weigh"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                product.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    //get product by id
    public Product getProductById(int id) {
        String sql = "SELECT idProduct,p.idCato,namePro,price,sale,Quantity,imgUrl,DescriptionN,DescriptionCT,"
                + "Weigh,c.nameCato FROM Product p,Catogory c WHERE p.idCato = c.idCato AND idProduct = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setIdProduct(rs.getInt("idProduct"));
                pro.setNamePro(rs.getString("namePro"));
                pro.setPrice(rs.getFloat("price"));
                pro.setSale(rs.getFloat("sale"));
                Catogory ca = new Catogory();
                ca.setIdCato(rs.getInt("idCato"));
                ca.setNameCato(rs.getString("nameCato"));
                pro.setIdCato(ca);
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setImgUrl(rs.getString("imgUrl"));
                pro.setWeigh(rs.getInt("Weigh"));
                pro.setDescriptionN(rs.getString("DescriptionN"));
                pro.setDescriptionCT(rs.getString("DescriptionCT"));
                return pro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //delete
    public void deleteProduct(int id) {
        String sql = "DELETE FROM Product WHERE idProduct = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update
    public void update(Product product) {
        try {
            String sql = "UPDATE Product SET idCato =?,namePro =?,price=?,sale=?,Quantity=?,imgUrl=?,"
                    + "DescriptionN=?,DescriptionCT=?,Weigh =? WHERE idProduct = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(10, product.getIdProduct());
            stm.setInt(1, product.getIdCato().getIdCato());
            stm.setString(2, product.getNamePro());
            stm.setFloat(3, product.getPrice());
            stm.setFloat(4, product.getSale());
            stm.setInt(5, product.getQuantity());
            stm.setString(6, product.getImgUrl());
            stm.setString(7, product.getDescriptionN());
            stm.setString(8, product.getDescriptionCT());
            stm.setInt(9, product.getWeigh());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add
    public void insert(Product product) {
        try {
            String sql = "INSERT INTO Product(idCato,namePro,price,sale,Quantity,imgUrl,"
                    + "DescriptionN,DescriptionCT,Weigh)VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, product.getIdCato().getIdCato());
            stm.setString(2, product.getNamePro());
            stm.setFloat(3, product.getPrice());
            stm.setFloat(4, product.getSale());
            stm.setInt(5, product.getQuantity());
            stm.setString(6, product.getImgUrl());
            stm.setString(7, product.getDescriptionN());
            stm.setString(8, product.getDescriptionCT());
            stm.setInt(9, product.getWeigh());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //test
    public static void main(String[] args) {
        ProductDAO pro = new ProductDAO();
      //  pro.getProductByCato1(1).forEach(System.out::println);
//        pro.getAllProductByPage(1, 8).forEach(System.out::println)
        //      pro.getProductByCato(1, 1, 8).forEach(System.out::println);
  //      pro.SearchProduct("bò", 1, 8).forEach(System.out::println);
    //       //    System.out.println(pro.countProductBySearch("bò"));
    }
}
