package com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling;

import com.github.alllef.Lipovetskii_Java_Web_lab1.thread.ExecutorHandler;

import java.io.File;

public class DirectoryTraverse {
    private File startFile;
    private ExecutorHandler executorHandler;

    public DirectoryTraverse(File startFile, ExecutorHandler executorHandler) {
        this.startFile = startFile;
        this.executorHandler = executorHandler;
    }

    public void traverse(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();

            for (String child : children) {
                if (!new File(child).isDirectory())
                    traverse(new File(dir, child));
                else
                    executorHandler.execute(dir);
            }

        }
    }
}
