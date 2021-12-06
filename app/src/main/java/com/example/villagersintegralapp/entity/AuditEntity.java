package com.example.villagersintegralapp.entity;

public class AuditEntity {
   String name;
   String integral;
   String status;
   String material;
   String explain;

    public AuditEntity(String name, String integral, String status, String material, String explain) {
        this.name = name;
        this.integral = integral;
        this.status = status;
        this.material = material;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
