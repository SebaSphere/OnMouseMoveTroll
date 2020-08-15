package com.sebasphere;

import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class TestUtils {

    ConfigHandler config = new ConfigHandler("access");


    public void playSong() {



        try{
            FileInputStream fis = new FileInputStream(config.fullFilePath());
            Player playMP3 = new Player(fis);

            playMP3.play();
            playMP3.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.println("Failed to play the file.");
        }

    }

}
