package com.leo.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by superleo on 3/28/16.
 */
public class MyHandler implements InvocationHandler {

    private Object obj;

    public MyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            // System.out.println("Proxy == " + prox        y);
            if (method.getName().equals("setData")) {
                System.out.println("Before Set Data.");
            }
            result = method.invoke(this.obj, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        Task task = (Task) Proxy.newProxyInstance(MyHandler.class.getClassLoader(), new Class[]{Task.class}, new MyHandler(new TaskImpl()));
        task.setData("123");
    }
}
