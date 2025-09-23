package michael.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteToFile {


    public static void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(textToAppend);
        fw.close();
    }


    public static void writeToPosition(String filename, int index, String oldData, String newData) {
        Path filePath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filePath);
            int indexToReplace = index;
            String line = lines.get(indexToReplace);
            String updatedLine = line.replace(oldData, newData);
            lines.set(indexToReplace, updatedLine);
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Oh no! I was not able to update the file: " + e.getMessage());
        }
    }


    public static void createFile(String filePath) {
        File f = new File(filePath);

        try {
            if (f.createNewFile()) {
                System.out.println("Yay! A file created successfully.");
            } else {
                System.out.println("I guess the file already exists or could not be created.");
            }
        } catch (IOException e) {
            System.out.println(" :{ an error occurred while creating the file: " + e.getMessage());
        }

    }

    public static void deleteTask(String fileName, int index) {
        Path filePath = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            int indexToDelete = index;
            if (indexToDelete >= 0 && indexToDelete < lines.size()) {
                lines.remove(indexToDelete);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    int dotPos = line.indexOf('.');
                    if (dotPos != -1) {
                        String restOfLine = line.substring(dotPos + 1).trim();
                        lines.set(i, i+1 + ". " + restOfLine);
                    }
                }
                Files.write(filePath, lines);
                System.out.println("Your task has been deleted successfully.");
            } else {
                System.out.println("Index out of bounds.");
            }
        } catch (IOException e) {
            System.out.println("Oh no! An error occurred: " + e.getMessage());
        }
    }

}

