package com.gupaoedu.vip.proxy.jdk;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class TestFindLove {

    @Test
    public void testLove(){
        new XiaoXingxing().findLove();
    }

    @Test
    public void test2() throws Exception {
        Person p = (Person) new Meipo().getInstance(new XiaoXingxing());
        p.findLove();

        //原理
        //1.拿到被代理对象到引用，然后获取它到接口
        //2.JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
        //3。把被代理对象的引用也拿到了
        //4.重新动态生成一个class字节码
        //5.然后编译


        //获取字节码内容
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});

        FileOutputStream os = new FileOutputStream("$Proxy0.class");
        os.write($Proxy0s);
        os.flush();

    }
}
