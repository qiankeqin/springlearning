package com.gupaoedu.vip.singleton;

//线程安全的单例模式
public class Singleton1 {
    //1.先声明一个静态内部类
    //private私有的保证别人不能修改
    //static保证全局唯一
    private static class LazyHolder{
        private static final Singleton1 INSTSNCE = new Singleton1();
    }

    //2。将默认构造函数私有化
    private Singleton1(){}
    //相当于有一个默认的public的无参构造方法，就意味着在代码中随时都可以new出来

    //3。同样提供静态方法获取实例
    //final确保别人不能覆盖
    public static final Singleton1 getInstance(){
        //方法中的逻辑，是要在用户调用的时候才开始执行的
        //方法中实现逻辑需要分配内存，也是调用的时候才进行分配的
        return LazyHolder.INSTSNCE;
    }
}
