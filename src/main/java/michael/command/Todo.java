package michael.command;

import michael.ui.Task;

import java.io.IOException;

import static michael.ui.WriteToFile.appendToFile;

public class Todo extends Task {

    public Todo(String description, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {

        super(description, index, "T", isTaskDone);
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

    public void writeFile(String dataFile) {

        String taskString = taskIndex + ". " + taskType + " | " + (isDone ? "1" : "0") + " | " + description;
        try {
            appendToFile(dataFile, taskString + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    @Override
    public String toString() {

        return "[T]" + super.toString();
    }
}
