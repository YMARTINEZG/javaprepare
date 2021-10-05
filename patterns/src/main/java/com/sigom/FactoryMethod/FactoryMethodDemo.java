package com.sigom.FactoryMethod;
// Factory pattern: deals with object creation at runtime without providing a specific class type
public class FactoryMethodDemo {
    public static void main(String[] args){
        BillExecutorFactory.getBillerExecutor("Print").sendBill();
        BillExecutorFactory.getBillerExecutor("Mail").sendBill();
    }
}
