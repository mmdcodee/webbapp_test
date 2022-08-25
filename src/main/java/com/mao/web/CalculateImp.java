package com.mao.web;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculateImp implements Calculate {
    @Override
    public void add(int i, int j) {
        System.out.println("result = " + (i + j));
    }
}

