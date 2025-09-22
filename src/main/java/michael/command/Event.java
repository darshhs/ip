package michael.command;

import michael.ui.Task;
import static michael.ui.WriteToFile.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {
        super(description, index, isTaskDone);
        this.from = from;
        this.to = to;
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

//
//    public void writeFile(String dataFile) {
//        String taskString = taskIndex + ". " + "E | "  +  (isDone ? "1" : "0") + " | " + description + " | " + from + "-" + to;
//        try {
//            appendToFile(dataFile, taskString + System.lineSeparator());
//        } catch (IOException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }
//
//    }


    @Override
    public String toString() {

        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
