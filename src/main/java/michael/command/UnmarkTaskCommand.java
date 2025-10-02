package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;

public class UnmarkTaskCommand extends Command{

    private final int currentTaskIndex;

    public UnmarkTaskCommand(int currentTask) {
        this.currentTaskIndex = currentTask;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        Task currentTask = tasks.get(currentTaskIndex);
        currentTask.markAsUndone(); //mark as done
        storage.writeToPosition( currentTaskIndex, "0", "1");
        ui.unmarkTaskMessage();
        System.out.println(currentTask);

    }
}
