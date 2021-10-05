package com.sigom.FactoryMethod;

public class BillingByPrint implements BillSender{
    @Override
    public void sendBill() {
        System.out.println("Print the Bill and send it by USPS ");
    }
}
