package com.sebasphere;

import com.sebasphere.checkers.MouseLocationThread;
import com.sebasphere.checkers.SoundThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {


    MouseLocationThread loc = new MouseLocationThread();

    SoundThread sound = new SoundThread();
    Thread t1 = new Thread(sound);




    public void init() {
        ConfigHandler config = new ConfigHandler("init"); //makes sure folders are in right place
    }
    public void runtime() {



        ExecutorService service = Executors.newFixedThreadPool(1);

        while (true) {
            try {

                Future<Integer> mouseLoc = service.submit(new MouseLocationThread());
                System.out.println(mouseLoc.get());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {

        new Main().init();
        new Main().runtime();

        //new Main().testingCode();









    }



    //testicles code. Needa remove soon enough
    public void testingCode() {
        //test.playSong();
        for (int x = 0; x < 1;) {
            if (!(t1.isAlive())) {
                x++;
                t1.run();
            }
        }
    }
}
