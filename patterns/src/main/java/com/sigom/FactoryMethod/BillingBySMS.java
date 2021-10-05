package com.sigom.FactoryMethod;

public class BillingBySMS implements BillSender{
    @Override
    public void sendBill() {
        System.out.println("Send the Bill by SMS......");
    }
}
