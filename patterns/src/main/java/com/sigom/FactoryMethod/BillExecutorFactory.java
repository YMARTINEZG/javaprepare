package com.sigom.FactoryMethod;

public class BillExecutorFactory {
    public static BillSender getBillerExecutor(String type){
        switch (type) {
            case "Mail":
                return new BillingByEmail();
            case "Print":
                return new BillingByPrint();
            case "SMS":
                return new BillingBySMS();
            default: return null;
        }
    }
}
