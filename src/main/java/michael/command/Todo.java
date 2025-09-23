package michael.command;

import michael.ui.Task;

public class Todo extends Task {

    public Todo(String description, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {

        super(description, index, "T", isTaskDone);
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

    @Override
    public String toString() {

        return "[T]" + super.toString();
    }
}
