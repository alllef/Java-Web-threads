package com.github.alllef.Lipovetskii_Java_Web_lab1.thread;

import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorHandler {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

    public void execute(File directory) {
        threadPoolExecutor.execute(new JavaFileSearch(directory));
    }
}
