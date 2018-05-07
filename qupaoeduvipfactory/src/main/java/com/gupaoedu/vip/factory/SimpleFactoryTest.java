package com.gupaoedu.vip.factory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        Car car = new SimpleFactory().getCar("bwm");
        System.out.println(car.getName());
    }
}
