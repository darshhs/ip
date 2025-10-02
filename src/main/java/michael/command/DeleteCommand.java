package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;

import static michael.Michael.numberTasks;

public class DeleteCommand extends Command {
    private final int currentTaskIndex;

    public DeleteCommand(int currentTask) {
        this.currentTaskIndex = currentTask;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        Task removedTask = tasks.get(currentTaskIndex);
        tasks.remove(removedTask);
        numberTasks--;
        storage.deleteTask(currentTaskIndex);
        ui.deleteTaskMessage(removedTask, numberTasks);

    }
}
