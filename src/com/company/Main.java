package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(

                new File("D://Gamess"),
                new File("D://Gamess//temp"),
                new File("D://Gamess//src"),
                new File("D://Gamess//res"),
                new File("D://Gamess//savegames"),
                new File("D://Gamess//src//main"),
                new File("D://Gamess//src//test"),
                new File("D://Gamess//res//drawables"),
                new File("D://Gamess//res//vectors"),
                new File("D://Gamess//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("D://Gamess//src//main//Main.java"),
                new File("D://Gamess//src//main//Utils.java"),
                new File("D://Gamess//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("D://Gamess//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D://Gamess//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
