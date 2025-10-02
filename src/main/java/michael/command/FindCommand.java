package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String query;

    public FindCommand(String query) {
        this.query = query;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        System.out.println("Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : tasks) {
            if (task.getDescription().contains(query)) {
                index = task.getTaskIndex();
                System.out.println(index + ". " + task);
            }
        }
    }

}
