package michael.command;

import michael.Storage.Storage;
import michael.Ui.UserMessages;
import michael.TaskList.Task;

import java.util.ArrayList;

public abstract class Command {
    public abstract void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage);

}

