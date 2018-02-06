package com.redcat.demo;

/**
 * Created by zhiyu.zhou on 2018/2/6.
 */
public class ConrecteSubject extends Subject {

    public void notifyDefinition() {
     for (Object object : observers) {
         ((Observer)object).update();
     }
    }
}
