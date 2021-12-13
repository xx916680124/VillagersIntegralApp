package com.example.villagersintegralapp.sql;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class VillagersEntity {
    @Id(autoincrement = true)
    long id;
    @Index(unique = true)
    String name;
    int age;
    String sex;
    int integral;
    String adress;
    int type;
   /* //设置自增长 唯一
    @Id(autoincrement = true)
    @Index(unique = true)
    private int id;

    //人员姓名
    private String name;

    private String password;*/
    @Generated(hash = 151277317)
    public VillagersEntity(long id, String name, int age, String sex, int integral,
            String adress, int type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.integral = integral;
        this.adress = adress;
        this.type = type;
    }
    @Generated(hash = 1274722071)
    public VillagersEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getIntegral() {
        return this.integral;
    }
    public void setIntegral(int integral) {
        this.integral = integral;
    }
    public String getAdress() {
        return this.adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }

}
