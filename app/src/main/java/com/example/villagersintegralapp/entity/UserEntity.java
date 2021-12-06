package com.example.villagersintegralapp.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class UserEntity implements MultiItemEntity {
    String name;
    int age;
    String sex;
    int integral;
    String adress;
    int type;

    public UserEntity() {
    }

    public UserEntity(String name, int age, String sex, int integral, String adress) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.integral = integral;
        this.adress = adress;
    }


    public UserEntity(String name, int age, String sex, int integral) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.integral = integral;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    @Override
    public int getItemType() {
        return 1;
    }
}
