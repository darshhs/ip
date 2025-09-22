package michael.ui;

import java.io.IOException;

import static michael.ui.WriteToFile.appendToFile;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected int taskIndex;

    public Task(String description, int index, String taskType, boolean isTaskDone) {
        this.description = description;
        this.isDone = isTaskDone;
        this.taskType = taskType;
        this.taskIndex = index;
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


