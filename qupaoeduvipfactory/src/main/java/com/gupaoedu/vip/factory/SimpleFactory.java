package com.gupaoedu.vip.factory;

public class SimpleFactory {

    //实现统一管理、专业化管理
    //如果没有工厂模式，小作坊没有标准
    //任何的工厂都有标准
    public Car getCar(String name){
        if("bwm".equalsIgnoreCase(name)){
            return new Bwm();
        }
        if("audi".equalsIgnoreCase(name)){
            return new Audi();
        }
        else{
            return null;
        }
    }
}
