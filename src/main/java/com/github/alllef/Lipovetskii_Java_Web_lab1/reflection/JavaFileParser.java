package com.github.alllef.Lipovetskii_Java_Web_lab1.reflection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileParser {
    private File file;

    public JavaFileParser(File file) {
        this.file = file;
        System.out.println("Changed file " + file.getName() + "in directory " + file.getParent());
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
        try (FileWriter writer = new FileWriter(file)) {

            for (String line : stringFile) {
                if (!line.contains("class"))
                    line = line.replace("public", "protected");
                writer.write(line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
