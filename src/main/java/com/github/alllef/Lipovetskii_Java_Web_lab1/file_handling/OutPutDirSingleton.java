package com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling;

import java.io.File;
import java.io.IOException;

public class OutPutDirSingleton {
    private static OutPutDirSingleton outPutDirSingleton = new OutPutDirSingleton();
    public File outputDir = new File("output_dir");

    public static OutPutDirSingleton getOutputDir() {
        return outPutDirSingleton;
    }

    private OutPutDirSingleton() {
    }

    public File recreateDir() {

        if (outputDir.exists()) {
            for (File tmp : outputDir.listFiles())
                tmp.delete();
            boolean result = outputDir.delete();
            System.out.println("Deleted " + result);
        }

        outputDir.mkdir();
        return outputDir;
    }
}
