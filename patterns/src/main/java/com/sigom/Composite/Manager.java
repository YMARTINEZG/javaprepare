package com.sigom.Composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Person{
    private String name;
    private List<Person> employees;

    public Manager(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Person person){
        employees.add(person);
    }
    public void show() {
        for(Person emp : employees){
            System.out.println(emp.getName());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Manager";
    }
}
