package com.gupaoedu.vip.custom;

import com.gupaoedu.vip.proxy.jdk.Person;
import com.gupaoedu.vip.proxy.jdk.XiaoXingxing;
import org.junit.Test;

import java.io.IOException;

public class TestGpProxy {

    @Test
    public void test() throws IOException {
        new GPMeipo().getInstance(new XiaoXingxing());
//        Person p = (Person) new GPMeipo().getInstance(new XiaoXingxing());
//        System.out.println(p.getClass());
//        p.findLove();
    }
}
