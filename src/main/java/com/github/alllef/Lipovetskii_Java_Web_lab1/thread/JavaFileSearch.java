package com.github.alllef.Lipovetskii_Java_Web_lab1.thread;

import com.github.alllef.Lipovetskii_Java_Web_lab1.reflection.JavaFileParser;

import java.io.File;

public class JavaFileSearch implements Runnable {
    private File directory;

    public JavaFileSearch(File directory) {
        this.directory = directory;
    }

    @Override
    public void run() {
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".java"))
                new JavaFileParser(file,new File("output_dir")).changeModifierToProtected();
        }
    }
}
