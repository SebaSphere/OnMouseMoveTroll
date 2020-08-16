package com.sebasphere;

import com.sebasphere.checkers.MouseAsync;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    ConfigHandler config = new ConfigHandler("init"); //makes sure folders are in right place
    String s = String.valueOf(config.getTimeToGetReady());
    int se = Integer.parseInt(s);







    public void runtime() {


        try {
            for (int x = se; se > 0; se--) {
                System.out.println("Get your mouse ready in " + se);
                TimeUnit.SECONDS.sleep(1);

            }
            Toolkit.getDefaultToolkit().beep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MouseAsync async = new MouseAsync();
        async.start();




    }



    public static void main(String[] args) {

        new Main().runtime();




    }


}
