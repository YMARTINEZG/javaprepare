package com.sigom.Template;

public class TuneUp extends WorkOrderTemplate{

    @Override
    public void removeBadComponent() {
        System.out.println("remove sparks from head engine");
        System.out.println("remove air filter");
        System.out.println("drain out old oil from engine");
        System.out.println("remove old oil filter");
        System.out.println("check tired presure");
    }

    @Override
    public void installGoodComponent() {
        System.out.println("install brand new sparks and plugs");
        System.out.println("clean out air filter and re-install");
        System.out.println("add new oil to the engine");
    }
}
