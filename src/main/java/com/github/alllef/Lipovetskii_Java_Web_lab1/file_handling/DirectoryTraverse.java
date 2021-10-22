package com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling;

import com.github.alllef.Lipovetskii_Java_Web_lab1.thread.ExecutorHandler;

import java.io.File;

public class DirectoryTraverse {
    private File startFile;
    private ExecutorHandler executorHandler = new ExecutorHandler();

    public DirectoryTraverse(File startFile) {
        this.startFile = startFile;
        OutPutDirSingleton.getOutputDir().recreateDir();
        traverse(startFile);

    }

    public void traverse(File dir) {

        File[] children = dir.listFiles();

        for (File child : children) {
            if (child.isDirectory()) {
                traverse(child);
                executorHandler.execute(child);
            }
        }
    }
}