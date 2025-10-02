package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;


public class MarkTaskCommand extends Command {

    private final int currentTaskIndex;

    public MarkTaskCommand(int currentTask) {
        this.currentTaskIndex = currentTask;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        Task currentTask = tasks.get(currentTaskIndex);
        currentTask.markAsDone(); //mark as done
        storage.writeToPosition(currentTaskIndex, "0", "1");
        ui.markTaskMessage();
        System.out.println(currentTask);
    }


}
