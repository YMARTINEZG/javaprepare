package com.sigom.Composite;

public class Employee implements Person{
    private String name;

    @Override
    public String getType() {
        return "Employee";
    }

    public Employee(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
