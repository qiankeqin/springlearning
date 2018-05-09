package com.gupaoedu.vip.template;

public class Coffee extends Bevegrage {



    @Override
    protected void brew() {
        System.out.println("make coffee");
    }

    @Override
    protected void addCoundiments() {
        System.out.println("add sugar");
    }
}
