package michael.command;

import michael.ui.Task;


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



    @Override
    public String toString() {

        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
