package com.mao.web;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculateProxy implements InvocationHandler {
    private Object target;

    //总要让我知道要代理谁吧：构造方法中把传入一个代理类的实例
    public CalculateProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("====== Before() ======");
        method.invoke(target, args);
        System.out.println("====== After () ======");
        return null;
    }
}
