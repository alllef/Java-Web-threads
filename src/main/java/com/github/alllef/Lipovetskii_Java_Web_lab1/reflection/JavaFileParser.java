package com.github.alllef.Lipovetskii_Java_Web_lab1.reflection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileParser {
    private File file;
    private File outputDir;

    public JavaFileParser(File file, File outputDir) {
        this.file = file;
        this.outputDir = outputDir;

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
        List<String> forbiddenTypes = List.of("class", "interface", "enum", "record");
        try (FileWriter writer = new FileWriter(new File(outputDir, file.getName()))) {

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
