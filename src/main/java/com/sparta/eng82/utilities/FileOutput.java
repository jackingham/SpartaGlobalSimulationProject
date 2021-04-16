package com.sparta.eng82.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

    public FileWriter createFile(String fileName, boolean append) {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(fileName, append);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myWriter;
    }

    public void appendToFile(String toFile) {
        try {
            FileWriter myWriter = this.createFile("simulation_output.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            bufferedWriter.write(toFile);
            bufferedWriter.newLine();

            bufferedWriter.close();
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void clearFile() {
        try {
            FileWriter myWriter = this.createFile("simulation_output.txt", false);
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
