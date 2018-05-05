package com.gupaoedu.vip.custom;

import com.gupaoedu.vip.proxy.jdk.Person;

import java.io.IOException;
import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {

    public Person p = null;

    public Object getInstance(Person p) throws IOException {
        this.p = p;
        Class clazz = p.getClass();
        System.out.println("被代理对象的class是："+clazz);
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        System.out.println(method.invoke(this.p,args));
        System.out.println("after");
        return null;
    }
}
