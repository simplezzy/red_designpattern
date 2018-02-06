package com.redcat.demo;

import java.util.ArrayList;

/**
 * Created by zhiyu.zhou on 2018/2/6.
 */
abstract class Subject {

    protected ArrayList<Observer> observers = new ArrayList();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //声明抽象通知方法
    public abstract void notifyDefinition();
}
