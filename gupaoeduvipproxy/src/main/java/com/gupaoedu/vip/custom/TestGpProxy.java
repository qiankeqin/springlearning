package com.gupaoedu.vip.custom;

import com.gupaoedu.vip.proxy.jdk.Person;
import com.gupaoedu.vip.proxy.jdk.XiaoXingxing;
import org.junit.Test;

import java.io.IOException;

public class TestGpProxy {

    @Test
    public void test() throws Exception {
        try {
            //new GPMeipo().getInstance(new XiaoXingxing());
            Person p = (Person) new GPMeipo().getInstance(new XiaoXingxing());
            //System.out.println(p.getClass());
            p.findLove();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Person.class.getMethod()
    }
}
