package com.example.tempplugin.util;

import com.intellij.openapi.diagnostic.Logger;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 播放音乐工具类
 *
 * @author Mr.YinHaijun
 */
public class PlayMusic {

    private static final Logger logger = Logger.getInstance(PlayMusic.class);

    public static void playMusic(String target) {
        File file = new File(target);
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream stream = new BufferedInputStream(fis)) {
            Player player = new Player(stream);
            player.play();
        } catch (Exception e) {
            logger.info("报错了，大概率是文件没找到{}", e);
        }
    }
}
