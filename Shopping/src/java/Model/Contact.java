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
public class Contact {
    private int idContact;
    private String phone,address,openTime,email;

    public Contact() {
    }

    public Contact(String phone, String address, String openTime, String email) {
        this.phone = phone;
        this.address = address;
        this.openTime = openTime;
        this.email = email;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" + "idContact=" + idContact + ", phone=" + phone + ", address=" + address + ", openTime=" + openTime + ", email=" + email + '}';
    }

    
    
}
