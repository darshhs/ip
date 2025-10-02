package michael.TaskList;

import java.io.IOException;

import static michael.Storage.Storage.appendToFile;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected int taskIndex;

    public String getDescription() {
        return description;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public Task(String description, int index, String taskType, boolean isTaskDone) {
        this.description = description;
        this.isDone = isTaskDone;
        this.taskType = taskType;
        this.taskIndex = index;
    }

    public String writeFileString() {
        return taskIndex + ". " + taskType + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    public void writeFile(String dataFile) {
        String taskString = writeFileString();
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


