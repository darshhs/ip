package michael.command;

import michael.ui.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import static michael.ui.WriteToFile.*;

public class Todo extends Task {

//    protected int taskIndex = 0;
//    protected boolean isNew;

    public Todo(String description, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {

        super(description, index, isTaskDone);
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

//
//    public void writeFile(String dataFile) {
//
//        String taskString = taskIndex + ". " + "T | " + (isDone ? "1" : "0") + " | " + description;
//        try {
//            appendToFile(dataFile, taskString + System.lineSeparator());
//        } catch (IOException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }
//
//    }


    @Override
    public String toString() {

        return "[T]" + super.toString();
    }
}
