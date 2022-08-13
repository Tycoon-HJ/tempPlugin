package com.example.tempplugin.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 配置一个公用的线程池,方便日后其他地方需要执行线程
 *
 * @author mr.ahai
 */
public class ThreadPoolConfig {
    private final ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
    private ThreadPoolExecutor threadPoolExecutor = null;

    /**
     * 运行一些线程
     *
     * @param runnable 线程
     */

    public void runSomething(Runnable runnable) {

        if (threadPoolExecutor == null) {
            threadPoolExecutor = getMusicThreadPoolExecutor();
        }
        threadPoolExecutor.execute(runnable);
    }


    /**
     * 获取一个线程池的实例
     */
    public ThreadPoolExecutor getMusicThreadPoolExecutor() {

        // 参数请根据自己的时间情况进行配置
        return new ThreadPoolExecutor(5,
                100, 60, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(20), threadFactory);

    }

}
