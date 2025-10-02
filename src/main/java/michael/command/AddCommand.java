package michael.command;

import static michael.Michael.numberTasks;


import michael.Ui.UserMessages;
import michael.Storage.Storage;
import michael.TaskList.Task;

import java.util.ArrayList;

public class AddCommand extends Command {
    private final Task task;
    private final boolean isDataNew;

    public AddCommand(Task task, boolean isDataNew) {
        this.task = task;
        this.isDataNew = isDataNew;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        tasks.add(task);
        numberTasks++;
        if (isDataNew) {
            ui.addTaskMessage(task, tasks.size());
        }
    }
}
