package michael;

import michael.command.Command;
import michael.Parser.ParseInput;
import michael.TaskList.Task;
import michael.Storage.Storage;
import michael.Ui.UserMessages;

import java.util.Scanner;
import java.util.ArrayList;


public class Michael {

    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int numberTasks = 0;
    public static String ending_line = "bye";
    public static String dataFile = "./data/data.txt";


    public static void main(String[] args) {

        UserMessages messages = new UserMessages();
        messages.welcomeMessage();

        Scanner in = new Scanner(System.in);
        String line = "";

        Storage storageFile = new Storage(dataFile);
        storageFile.getFileData();


        while (!(line.equals(ending_line))) {

            line = in.nextLine();
            ParseInput parser = new ParseInput(line);
            Command command = parser.parse();
            command.execute(tasks, messages, storageFile);

        }
    }
}
