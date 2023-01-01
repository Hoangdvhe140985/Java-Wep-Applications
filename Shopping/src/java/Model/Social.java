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
public class Social {
    private int id;
    private String url;
    private String logo;

    public Social() {
    }

    public Social(String url) {     
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    
    @Override
    public String toString() {
        return "Social{" + "id=" + id + ", url=" + url + ", logo=" + logo +'}';
    }
    
        
    
}
