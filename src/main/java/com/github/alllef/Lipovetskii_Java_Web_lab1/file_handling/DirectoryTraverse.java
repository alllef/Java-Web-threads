package com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling;

import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

public class DirectoryTraverse {
    private File startFile;

    public DirectoryTraverse(File startFile, ThreadPoolExecutor threadPoolExecutor) {
        this.startFile = startFile;
    }

    public void traverse(File dir){
        if (dir.isDirectory()) {
            String[] children = dir.list();

            for (String child : children) {
             if (!new File(child).isDirectory())
                 System.out.println(child);
                 traverse(new File(dir, child));
            }
            }
    }
}
