package com.sebasphere;

public class Main {

    ConfigHandler config = new ConfigHandler("init");

    TestUtils test = new TestUtils();

    SoundThread sound = new SoundThread();
    Thread t1 = new Thread(sound);

    public static void main(String[] args) {

        new Main().run();









    }


    //testicles code. Needa remove soon enough
    public void run() {
        //test.playSong();
        for (int x = 0; x < 3;) {
            if (!(t1.isAlive())) {
                x++;
                t1.run();
            }
        }
    }
}
