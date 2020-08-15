package com.sebasphere;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ConfigHandler {

    private File source = new File(this.getClass().getClassLoader().getResource("config.yml").getPath());
    private File dest = new File("config.yml");
    private File soundDir= new File("sounds/");

    private int length;
    private byte[] buffer = new byte[1024];


    private Object fileName;
    private Object timeToGetReady;
    private Object amountAfterLeave;
    private Object playParameters;


    /**
     * access is to read config values for use in other classes
     * @param type init | access
     */
    public ConfigHandler(String type) {
        if (type.equals("init")) {
            createConfigFile();
            createFilePaths();
        }
        if (type.equals("access")) {
            readConfigValues();
        }
    }


    private void readConfigValues() {
        YamlReader reader = null;
        try {
            reader = new YamlReader(new FileReader(dest));
            Object object = reader.read();
            Map map = (Map)object;
            this.fileName = map.get("FileName");
            this.timeToGetReady = map.get("TimeToGetReady");
            this.amountAfterLeave = map.get("AmountAfterLeave");
            this.playParameters = map.get("PlayParameters");


        } catch (FileNotFoundException | YamlException e) {
            e.printStackTrace();
        }
    }


    private void createFilePaths() {
        if (!(soundDir.exists())) {
            try {
                System.out.println("sounds/ folder does not exist. Creating");
                Path path = Paths.get(String.valueOf(soundDir));
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void createConfigFile() {
        try {
            if (!(dest.exists())) {

                //creates file if it doesn't exist
                FileInputStream fileInputStream = new FileInputStream(source);
                FileOutputStream fileOutputStream = new FileOutputStream(dest);
                System.out.println("Config file does not exist. Creating config.yml now");


                while ((length = fileInputStream.read(buffer)) > 0) {

                    fileOutputStream.write(buffer, 0, length);
                }
            }
            //file exists, not doing anything
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //getters for yaml file values here
    /**
     * @return returns the file name inside the config.yml
     */
    public String  getFileName() {
        return (String) fileName;
    }
    /**
     * @return The amount of time before the bounding box drops
     */
    public Object getTimeToGetReady() {
        return timeToGetReady;
    }
    /**
     * @return The amount of time after your mouse leaves the bounding box before sound plays
     */
    public Object getAmountAfterLeave() {
        return amountAfterLeave;
    }

    /**
     * @return Determines how the program will play
     */
    public Object getPlayParameters() {
        return playParameters;
    }
    public String fullFilePath() {
        return soundDir + "/" + getFileName();
    }
}








