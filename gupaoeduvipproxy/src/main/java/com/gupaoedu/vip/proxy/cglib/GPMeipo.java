package com.gupaoedu.vip.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GPMeipo implements MethodInterceptor {


    //疑问？
    //好像没有定义引用对象？
    public Object getInstance(Object obj){
        Enhancer enhancer = new Enhancer();
        //将父类设置为谁
        //告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(obj.getClass());
        //调用回调
        enhancer.setCallback(this);

        //第一步：生成源代码
        //第二步：编译成class文件
        //第三步：加载到jvm中，并返回被代理对象
        return enhancer.create();
    }

    //同样是做了字节码重组这样一件事情
    //对于api的使用者来说，是无感知的。
    //引用对象o是cglib帮我们生成的。这个对象是被代理对象的子类，（继承了我们自己写的那个类）
    //OOP，在new子类之前，实际上默认是调用了我们的super（）方法的
    //new子类的同时，必须先new出来父类，这就相当于间接的持有我们父类的引用
    //子类重写父类的所有的方法
    //我们改变子类对象的某些属性，是可以间接的操作父类的属性
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("before");

        //o是生成的子类
        //如果o调用本身，就会发生死循环，所以需要调用父类中的方法
        methodProxy.invokeSuper(o,args);

        System.out.println("after");
        return null;
    }
}
