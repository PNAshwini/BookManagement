/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tarun
 */
public class Order {
    protected int oid;
    protected String bname;
    protected String bprice;
    protected String bquantity;
    protected String cname;
    protected String phone;
    protected String email;
    protected String address;

    public Order(int oid, String bname, String bprice, String bquantity, String cname, String phone, String email, String address) {
        super();
        this.oid = oid;
        this.bname = bname;
        this.bprice = bprice;
        this.bquantity = bquantity;
        this.cname = cname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    public Order(String bname, String bprice, String bquantity, String cname, String phone, String email, String address) {
        super();
        this.bname = bname;
        this.bprice = bprice;
        this.bquantity = bquantity;
        this.cname = cname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    public String getBquantity() {
        return bquantity;
    }

    public void setBquantity(String bquantity) {
        this.bquantity = bquantity;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
