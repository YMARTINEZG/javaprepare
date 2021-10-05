package com.sigom.FactoryMethod;

public class BillingByEmail implements BillSender{
    @Override
    public void sendBill() {
        System.out.println("Send Bill by email.......");
    }
}
