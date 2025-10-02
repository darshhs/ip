package michael.command;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;

import java.util.ArrayList;

import static michael.Michael.numberTasks;

public class ShowListCommand extends Command {

    public ShowListCommand() {
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        System.out.println("Hello there! Certainly, here are the tasks in your list:");
        for (int i = 0; i < numberTasks; i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
        System.out.println("You currently have " + numberTasks + " task(s)");
    }

}
