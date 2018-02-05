package com.redcat.demo;

/**
 * Created by zhiyu.zhou on 2018/2/5.
 */

/**
 * 双重锁校验模式 双重检查锁定才能够正常达到单例效果
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleton() {
        if(null == singleton) {
            synchronized (Singleton.class) {
                if(null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
