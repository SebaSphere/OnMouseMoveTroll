package com.sebasphere.checkers;

import com.sebasphere.ConfigHandler;
import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class SoundThread extends Thread {

    ConfigHandler config = new ConfigHandler("access");

    @Override
    public void run() {
        try{
            FileInputStream fis = new FileInputStream(config.fullFilePath());
            Player playMP3 = new Player(fis);

            playMP3.play();
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.println("Failed to play the file.");
        }
    }
}
