package com.atme.webssm.pojo;

/**
 * 提交的价格和页面的页数
 */
public class Price {
    private Integer minPrice;
    private Integer maxPrice;
    private Integer pageNum;

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNo(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Price{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", pageNum=" + pageNum +
                '}';
    }
}
