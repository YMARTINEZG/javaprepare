package com.sigom.Composite;


public class CompositeEmployeeClient {

    public static void main(String[] args){
        Employee dev1 = new Employee("Juan");
        Employee dev2 = new Employee("Ricki");
        Employee dev3 = new Employee("Sonya");
        Employee ope1 = new Employee("Mario");
        Manager boos1 = new Manager("Jefe1");
        Manager boos2 = new Manager("Jefe2");
        boos1.addEmployee(dev1);
        boos1.addEmployee(boos2);
        boos1.addEmployee(dev3);
        //System.out.println(boos1.getName());
        boos1.show();
    }
}
