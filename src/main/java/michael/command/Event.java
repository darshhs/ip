package michael.command;

import michael.ui.Task;

import java.io.IOException;

import static michael.ui.WriteToFile.appendToFile;


public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {
        super(description, index, "E", isTaskDone);
        this.from = from;
        this.to = to;
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }


    public void writeFile(String dataFile) {
        String taskString = taskIndex + ". " + taskType + " | "  +  (isDone ? "1" : "0") + " | " + description + " | " + from + "-" + to;
        try {
            appendToFile(dataFile, taskString + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }



    @Override
    public String toString() {

        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
