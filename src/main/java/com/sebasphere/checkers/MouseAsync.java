package com.sebasphere.checkers;

import net.rom.lib.async.Async;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MouseAsync {
    private final MouseLocationCheck check = new MouseLocationCheck();
    private final Point point = new Point(check.mouseLocX(), check.mouseLocY());
    private final SoundThread sound = new SoundThread();
    private final Thread t1 = new Thread(sound);



    private synchronized void runTroll() {
        PointerInfo info = MouseInfo.getPointerInfo();
        if (!info.getLocation().equals(point)) {
            t1.run();
        }
    }

    public void start() {


        Async.task("Troll Thread", () -> {
            runTroll();
        }, 20, TimeUnit.MILLISECONDS);
    }
}
