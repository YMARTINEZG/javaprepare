package com.sigom.Template;


/*
create a method stub and deferring some of the steps of implementation to the subclasess
Behavioral design pattern
 */
public abstract class WorkOrderTemplate {

    // template method , final --> subclasses can't override
    public final void processWorkOrder(String type){
        System.out.println("Work Order for : " + type);
        searchComponents();
        removeBadComponent();
        installGoodComponent();
        signOnWorkOrder();
    }
    private void searchComponents(){
        System.out.println("call to the store for required part");
    }
    public abstract void removeBadComponent();
    public abstract void installGoodComponent();
    private void signOnWorkOrder(){
        System.out.println("get the manager sign off");
    }
}
