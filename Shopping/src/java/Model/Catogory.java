/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class Catogory implements Serializable {

    private int idCato;
    private String nameCato;

    ArrayList<Product> product = new ArrayList<>();

    public Catogory(int idCato, String nameCato) {
        this.idCato = idCato;
        this.nameCato = nameCato;
    }

    public Catogory() {
    }

    public int getIdCato() {
        return idCato;
    }

    public void setIdCato(int idCato) {
        this.idCato = idCato;
    }

    public String getNameCato() {
        return nameCato;
    }

    public void setNameCato(String nameCato) {
        this.nameCato = nameCato;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "" + nameCato;
    }

}
