package com.sebasphere.checkers;

import java.awt.*;
import java.util.concurrent.Callable;

public class MouseLocationThread implements Callable<Integer> {

    private int x;
    private int y;


    @Override
    public Integer call() throws Exception {
        PointerInfo info = MouseInfo.getPointerInfo();
        int x = info.getLocation().x;
        return x;
    }
}









//    public void checkPlayParameters() {
//        if (config.getPlayParameters().equals("ONCE")) {
//            System.out.println("ONCE");
//        } else if (config.getPlayParameters().equals("LOOP")) {
//            System.out.println("LOOP");
//        } else {
//            System.out.println("something else");
//        }
//    }