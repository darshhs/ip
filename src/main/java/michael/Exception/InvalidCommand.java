package michael.Exception;

import michael.Storage.Storage;
import michael.TaskList.Task;
import michael.Ui.UserMessages;
import michael.command.Command;

import java.util.ArrayList;

public class InvalidCommand extends Command {
    private final String errorMsg;

    public InvalidCommand(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public void execute(ArrayList<Task> tasks, UserMessages ui, Storage storage) {
        System.out.println(errorMsg);
    }
}
