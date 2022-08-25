package com.mao.web;

//import java.lang.reflect.Method;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        InvocationHandler handler = new CalculateProxy(new CalculateImp());
        Calculate calculateProxy =
                (Calculate) Proxy.newProxyInstance(Calculate.class.getClassLoader(),
                        new Class[]{Calculate.class},
                        handler);
        calculateProxy.add(10,20);
    }
}

