package com.syw.showmeshopsyw.entity;
public class Clothes {
    private Integer id;
    private String name;
    private String color;
    private String size;
    private Integer sex;
    private String picAddress1;
    private String picAddress2;
    private Double oldPrice;
    private Double newPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPicAddress1() {
        return picAddress1;
    }

    public void setPicAddress1(String picAddress1) {
        this.picAddress1 = picAddress1;
    }

    public String getPicAddress2() {
        return picAddress2;
    }

    public void setPicAddress2(String picAddress2) {
        this.picAddress2 = picAddress2;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }
}