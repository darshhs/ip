package michael.TaskList;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by, String dataFilePath, int index, boolean isTaskDone, boolean isDataNew) {
        super(description, index, "D", isTaskDone);
        this.by = by;
        if (isDataNew) {
            writeFile(dataFilePath);
        }
    }

    @Override
    public String writeFileString() {
        return super.writeFileString() + " | " + by;
    }


    @Override
    public String toString() {

        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
