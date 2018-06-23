package com.hankkin.compustrading.test.bean;

/**
 * Created by think on 2018/3/20.
 */

public class ProductInfo {
    private int id;
    private String name;
    private String price;
    private String desc;
    private String user_tel;
    private int cid;
    private String product_url;
    private String school;
    private String username;
    private String user_icon_url;
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ProductInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_icon_url() {
        return user_icon_url;
    }

    public void setUser_icon_url(String user_icon_url) {
        this.user_icon_url = user_icon_url;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", desc='" + desc + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", cid=" + cid +
                ", product_url='" + product_url + '\'' +
                ", school='" + school + '\'' +
                ", username='" + username + '\'' +
                ", user_icon_url='" + user_icon_url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

}
