package com.gupaoedu.vip.custom;

import java.lang.reflect.Method;

/**
 * 仿照InvocationHandler接口
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
