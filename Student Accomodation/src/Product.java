/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAHIDUL ISLAM
 */
public class Product {
    
    private String name;
    private String address;
    private String phone;
    
    public Product(){
        
        this.name= "";
        this.address="";
        this.phone="";
    }
    public Product (String name, String address ,String phone)
    {
        this.name=name;
        this.address= address;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
      
}




