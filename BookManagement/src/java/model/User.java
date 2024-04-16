/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tarun
 */
public class User {
    protected int id;
    protected String fname;
    protected String uname;
    protected String password;
    protected String cpassword;

    public User() {
    }

    public User(int id, String fname, String uname, String password, String cpassword) {
        super();
        this.id = id;
        this.fname = fname;
        this.uname = uname;
        this.password = password;
        this.cpassword = cpassword;
    }
    public User(String fname, String uname, String password, String cpassword) {
        super();
        this.fname = fname;
        this.uname = uname;
        this.password = password;
        this.cpassword = cpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
	

	
}
