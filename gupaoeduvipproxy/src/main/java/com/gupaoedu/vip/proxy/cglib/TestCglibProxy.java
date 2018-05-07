package com.gupaoedu.vip.proxy.cglib;

public class TestCglibProxy {
    public static void main(String[] args) {

        //jdk的动态代理是通过接口来进行强制转换的
        //生成以后的代理对象，可以强制转换为接口

        //cglib的动态代理，是通过一个被代理对象的子类，然后重写父类的方法
        //生成以后的对象，可以强制欢欢为被代理对象（也就是用自己写的类）
        //子类引用赋值给父类

//        YunZhongYu obj = (YunZhongYu) new GPMeipo().getInstance("com.gupaoedu.vip.proxy.cgli.YunZhongYu");
        YunZhongYu obj = (YunZhongYu) new GPMeipo().getInstance(new YunZhongYu());
        obj.findLove();

    }
}
