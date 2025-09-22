package michael.command;

import michael.ui.Task;

import java.io.IOException;

import static michael.ui.WriteToFile.appendToFile;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {
        super(description, index, "D", isTaskDone);
        this.by = by;
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

    public void writeFile(String dataFile) {
        String taskString = taskIndex + ". " + taskType + " | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
        try {
            appendToFile(dataFile, taskString + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }


    @Override
    public String toString() {

        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
