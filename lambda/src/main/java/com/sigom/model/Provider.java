package com.sigom.model;


public class Provider {
    private String name;
    private String area;
    private String type;
    private String email;

    public Provider() {
    }

    public Provider(String name, String area, String type, String email) {
        this.name = name;
        this.area = area;
        this.type = type;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }
}
