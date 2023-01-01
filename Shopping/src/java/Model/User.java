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
public class User {
    private int idUser;
    private String userName,pass,names;
    private boolean gender;
    private String address,email,phone;
    private int role;

    public User() {
    }

    public User(int idUser, String userName, String pass, String names, boolean gender, String address, String email, String phone, int role) {
        this.idUser = idUser;
        this.userName = userName;
        this.pass = pass;
        this.names = names;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
    
    public User(String userName, String pass, String names, boolean gender, String address, String email, String phone, int role) {       
        this.userName = userName;
        this.pass = pass;
        this.names = names;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", userName=" + userName + ", pass=" + pass + ", names=" + names + ", gender=" + gender + ", address=" + address + ", email=" + email + ", phone=" + phone + ", role=" + role + '}';
    }
    
    
}
