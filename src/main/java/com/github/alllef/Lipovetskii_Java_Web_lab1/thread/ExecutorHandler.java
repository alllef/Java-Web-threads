package com.github.alllef.Lipovetskii_Java_Web_lab1.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorHandler {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    public void execute() {
        for (int i = 0; i < 5; i++)
            threadPoolExecutor.execute(new RunnableCommand());
    }
}
