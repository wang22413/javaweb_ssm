package com.atme.webssm.pojo;

public class User {
    private Integer id ;
    private String uname ;
    private String pwd ;
    private Integer role ;
    private String email;

    private Cart cart;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String uname, String pwd, Integer role, String email) {
        this.uname = uname;
        this.pwd = pwd;
        this.role = role;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
