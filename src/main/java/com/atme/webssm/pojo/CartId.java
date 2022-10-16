package com.atme.webssm.pojo;

public class CartId {

    private Integer id ;
    private Integer book ;
    private Integer buyCount ;
    private Integer userBean ;

    public CartId() {
    }

    public CartId(Integer book, Integer buyCount) {
        this.book = book;
        this.buyCount = buyCount;
    }

    public CartId(Integer id, Integer book, Integer buyCount, Integer userBean) {
        this.id = id;
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
    }
}
