package com.gupaoedu.vip.template;

public class Tea extends Bevegrage{

    @Override
    protected void brew() {
        System.out.println("make tea");
    }

    @Override
    protected void addCoundiments() {
        System.out.println("add honey");
    }
}
