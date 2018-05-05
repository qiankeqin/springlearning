package com.gupaoedu.vip.custom;
import java.lang.reflect.Method;
public class $Proxy0 extends com.gupaoedu.vip.proxy.jdk.Person{
GPInvocationHandler h;
public $Proxy0(GPInvocationHandler h){
this.h = h;}
public void findLove() {
try{
Method m = com.gupaoedu.vip.proxy.jdk.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
} catch(Exception ex){
}
}
}
