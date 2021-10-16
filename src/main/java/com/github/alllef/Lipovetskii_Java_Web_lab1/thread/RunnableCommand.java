package com.github.alllef.Lipovetskii_Java_Web_lab1.thread;

import java.util.List;
import java.util.Random;

public class RunnableCommand implements Runnable {
    List<String> list = List.of("a","b","c","d");
    @Override
    public void run() {
        int res = new Random().nextInt(list.size());
        System.out.println(res);
    }
}
