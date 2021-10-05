package com.sigom.Template;


public class WorkOrderClient {
    public static void main(String[] args){

        WorkOrderTemplate workOrder = new ChangeOil();
        workOrder.processWorkOrder("Change oil");
        System.out.println("************");
        workOrder = new TuneUp();

        workOrder.processWorkOrder("Tune up");
    }
}
