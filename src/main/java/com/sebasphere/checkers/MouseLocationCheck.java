package com.sebasphere.checkers;

import java.awt.*;

public class MouseLocationCheck {

    private Point info = MouseInfo.getPointerInfo().getLocation();

    public int mouseLocX() {
        return info.getLocation().x;
    }
    public int mouseLocY() {
        return info.getLocation().y;
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