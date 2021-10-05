package com.sigom.Template;

public class ChangeOil extends WorkOrderTemplate {
    @Override
    public void removeBadComponent() {
        System.out.println("drain out the old oil from the engine");
    }

    @Override
    public void installGoodComponent() {
        System.out.println("Change the oil filter and add new oil");
    }
}
