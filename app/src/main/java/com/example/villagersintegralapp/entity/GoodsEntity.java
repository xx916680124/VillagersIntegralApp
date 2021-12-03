package com.example.villagersintegralapp.entity;

public class GoodsEntity {
    private String img;
    private int integral;

    public GoodsEntity() {
    }

    public GoodsEntity(String img, int integral) {
        this.img = img;
        this.integral = integral;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}
