package com.gupaoedu.vip.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo implements InvocationHandler {

    private Person target = null;

//    public Meipo(Person target){
//        this.target = target;
//    }

    public Object getInstance(Person target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        //为xiaoxingxing生成代理对象
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(target,args);
        System.out.println("after");
        return null;
    }
}
