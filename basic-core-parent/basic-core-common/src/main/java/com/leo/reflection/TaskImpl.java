package com.leo.reflection;

/**
 * Created by superleo on 3/28/16.
 */
public class TaskImpl implements Task {
    @Override
    public void setData(String data) {
        System.out.println(data + " Data is saved");
    }

    @Override
    public int getCalData(int x) {
        return x * 10;
    }

    public String toString(){
        System.out.println("Task......");
        return "OK";
    }
}
