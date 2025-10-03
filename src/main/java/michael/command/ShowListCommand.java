package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;

import static michael.Michael.numberTasks;

/**
 * Represents a command to display the current list of tasks.
 * Shows all tasks and the total count to the user.
 */
public class ShowListCommand extends Command {
    /**
     * Constructs a ShowListCommand.
     */
    public ShowListCommand() {
    }

    /**
     * Executes the show list command, printing all tasks and the count.
     * @param tasks The list of tasks
     * @param ui The user interface for messages
     * @param storage The storage handler
     */
    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        System.out.println("Hello there! Certainly, here are the tasks in your list:");
        for (int i = 0; i < numberTasks; i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
        System.out.println("You currently have " + numberTasks + " task(s)");
    }
}
