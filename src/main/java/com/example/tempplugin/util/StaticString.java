package com.example.tempplugin.util;

/**
 * 存放一些静态变量
 * @author Mr.YinHaijun
 */
public class StaticString {

    private StaticString() {

    }


    /**
     * 项目的groupId
     */
    public static final String GROUP_ID = "com.example.tempplugin.testKiss";

    /**
     * 通知
     */
    public static final String CONTENT = "这里存放一些通知";

    /**
     * 毒鸡汤的在线地址
     */
    public static final String POISON_CHICKEN_SOUP_URL = "https://api.nextrt.com/V1/Dutang";

    /**
     * 测试阶段本地音乐播放路径( ps: 仅支持mp3格式，wav不支持！！！！，可通过更改第三方jar包扩展此功能)
     */
    public static final String LOCAL_MUSIC_PATH = "/Users/mr.ahai/IdeaProjects/tempPlugin/tempPlugin/src/main/resources/static/water.mp3";

    /**
     * 打包时需要使用的路径
     */
    public static final String ONLINE_MUSIC_PATH = "/static/water.mp3";
}
