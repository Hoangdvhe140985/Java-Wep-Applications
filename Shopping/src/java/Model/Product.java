/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hoang
 */
public class Product {

    private int idProduct;
    private Catogory idCato;
    private String namePro;
    private float price;
    private float sale;
    private int quantity;
    private String imgUrl;
    private String descriptionN;
    private String descriptionCT;
    private int weigh;

    public Product() {
    }

    public Product(Catogory idCato, String namePro, float price, float sale, int quantity, String imgUrl, String descriptionN, String descriptionCT, int weigh) {
      
        this.idCato = idCato;
        this.namePro = namePro;
        this.price = price;
        this.sale = sale;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
        this.descriptionN = descriptionN;
        this.descriptionCT = descriptionCT;
        this.weigh = weigh;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Catogory getIdCato() {
        return idCato;
    }

    public void setIdCato(Catogory idCato) {
        this.idCato = idCato;
    }

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescriptionN() {
        return descriptionN;
    }

    public void setDescriptionN(String descriptionN) {
        this.descriptionN = descriptionN;
    }

    public String getDescriptionCT() {
        return descriptionCT;
    }

    public void setDescriptionCT(String descriptionCT) {
        this.descriptionCT = descriptionCT;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", idCato=" + idCato + ", namePro=" + namePro + ", price=" + price + ", sale=" + sale + ", quantity=" + quantity + ", imgUrl=" + imgUrl + ", descriptionN=" + descriptionN + ", descriptionCT=" + descriptionCT + ", weigh=" + weigh + '}';
    }

    

}
