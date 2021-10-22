package com.github.alllef.Lipovetskii_Java_Web_lab1.menu;

import com.github.alllef.Lipovetskii_Java_Web_lab1.file_handling.DirectoryTraverse;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void start() {
        DirectoryTraverse traverse;
        while (true) {

            System.out.println("Enter full path of directory where I " +
                    "can change methods and fields of files from public to protected");
            Scanner scanner = new Scanner(System.in);
            File directory = new File(scanner.nextLine());

            if (!directory.exists())
                System.out.println("You entered directory that does not exists");

            else {
                traverse = new DirectoryTraverse(directory);
                System.out.println("All changed files are successfully saved in output_dir");
            }
        }
    }


}
