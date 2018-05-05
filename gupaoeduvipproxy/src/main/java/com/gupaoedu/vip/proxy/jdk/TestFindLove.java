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
        //


        //获取字节码内容
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});

        FileOutputStream os = new FileOutputStream("$Proxy0.class");
        os.write($Proxy0s);
        os.flush();

    }
}
