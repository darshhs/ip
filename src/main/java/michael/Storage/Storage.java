package michael.Storage;

import michael.Parser.ParseInput;
import michael.TaskList.Deadline;
import michael.TaskList.Event;
import michael.TaskList.Task;
import michael.TaskList.Todo;
import michael.Ui.UserMessages;
import michael.command.AddCommand;
import michael.command.Command;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static michael.Michael.*;

public class Storage {

    private String fileName = "./data/data.txt";

    public static void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(textToAppend);
        fw.close();
    }


    public void writeToPosition(int index, String oldData, String newData) {
        Path filePath = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            String line = lines.get(index);
            String updatedLine = line.replace(oldData, newData);
            lines.set(index, updatedLine);
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Oh no! I was not able to update the file: " + e.getMessage());
        }
    }


    public void createFile(String filePath) {
        File f = new File(filePath);
        File parentDir = f.getParentFile();


        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Parent directory created successfully.");
            } else {
                System.out.println("Failed to create parent directory.");
                return;
            }
        }

        try {
            if (f.createNewFile()) {
                System.out.println("Yay! A file created successfully.");
            }
        } catch (IOException e) {
            System.out.println(" :{ an error occurred while creating the file: " + e.getMessage());
        }

    }

    public void deleteTask(int index) {
        Path filePath = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            if (index >= 0 && index < lines.size()) {
                lines.remove(index);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    int dotPos = line.indexOf('.');
                    if (dotPos != -1) {
                        String restOfLine = line.substring(dotPos + 1).trim();
                        lines.set(i, i + 1 + ". " + restOfLine);
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

    public Storage(String fileName) {
        this.fileName = fileName;
        createFile(fileName);
    }

    public void getFileData() {
        File f = new File(fileName);
        Scanner s = null;
        Task task;
        Command addCommand;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean isTaskDone;
        while (s.hasNext()) {
            String line = s.nextLine();
            int dotPos = line.indexOf('.');
            if (dotPos != -1) {
                String restOfLine = line.substring(dotPos + 1);
                isTaskDone = restOfLine.charAt(5) == '1';
                if (restOfLine.charAt(1) == 'T') {

                    task = new Todo(restOfLine.substring(9), dataFile, numberTasks + 1, isTaskDone, false);
                    addCommand = new AddCommand(task, false);
                    addCommand.execute(tasks, new UserMessages(), new Storage(fileName));

                } else if (restOfLine.charAt(1) == 'D') {

                    String taskSub = restOfLine.substring(9);
                    String newTaskSub = "deadline " + taskSub.replace("|", "/by");
                    ParseInput deadlinerParser = new ParseInput(newTaskSub);
                    String[] deadlineInstruction = deadlinerParser.parseDeadline();

                    task = new Deadline(deadlineInstruction[0], deadlineInstruction[1], dataFile, numberTasks + 1, isTaskDone, false);
                    addCommand = new AddCommand(task, false);
                    addCommand.execute(tasks, new UserMessages(), new Storage(fileName));

                } else {
                    String taskSub = restOfLine.substring(9);
                    String newTaskSub = taskSub.replace("|", "/from");
                    newTaskSub = "event " + newTaskSub.replace("-", " /to ");
                    ParseInput eventParser = new ParseInput(newTaskSub);
                    String[] eventInstruction = eventParser.parseEvent();

                    task = new Event(eventInstruction[0], eventInstruction[1], eventInstruction[2], dataFile, numberTasks + 1, isTaskDone, false);
                    addCommand = new AddCommand(task, false);
                    addCommand.execute(tasks, new UserMessages(), new Storage(fileName));
                }
            }
        }
    }
}

