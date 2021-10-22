package com.github.alllef.Lipovetskii_Java_Web_lab1.parsing;

import com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling.OutPutDirSingleton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileParser {
    private File file;
    private File outputDir;

    public JavaFileParser(File file) {
        this.file = file;
        outputDir = OutPutDirSingleton.getOutputDir().outputDir;
        System.out.println("Changed file " + file.getAbsolutePath());
    }


    private List<String> getFileAsStringLines() {
        List<String> stringFile = new ArrayList<>();

        try {
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine())
                stringFile.add(scanner.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringFile;
    }

    public File changeModifierToProtected() {
        List<String> stringFile = getFileAsStringLines();
        List<String> forbiddenTypes = List.of("class", "interface", "enum", "record");
        File tmp = new File(outputDir, file.getName());

        try {
            tmp.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(tmp)) {

            for (String line : stringFile) {
                if (forbiddenTypes.stream()
                        .anyMatch(line::contains)) {
                    line = line.replace("public", "protected");
                    writer.write(line + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
