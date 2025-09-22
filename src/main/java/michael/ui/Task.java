package michael.ui;


import java.io.IOException;

import static michael.ui.WriteToFile.appendToFile;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected int taskIndex;

    public Task(String description, int index, boolean isTaskDone) {
        this.description = description;
        this.isDone = isTaskDone;
        this.taskType = "none";
        this.taskIndex = index;
    }


    public void writeFile(String dataFile) {

        String taskString = taskIndex + ". " + "T | " + (isDone ? "1" : "0") + " | " + description;
        try {
            appendToFile(dataFile, taskString + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    public String getStatusIcon() {

        return (isDone ? "X" : " "); // mark done task with X
    }


    public void markAsDone() {

        isDone = true;
    }

    public void markAsUndone() {

        isDone = false;
    }

    public String toString() {

        return "[" + getStatusIcon() + "] " + description;
    }
}


