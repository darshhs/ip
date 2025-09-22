package michael.ui;

import michael.command.Deadline;
import michael.command.Event;
import michael.command.Todo;
import michael.exception.NumberRangeException;
import michael.exception.EmptyException;
import michael.exception.UnknownInstructionException;
import michael.command.Todo.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


import static michael.ui.WriteToFile.*;

public class Michael {

    private static ArrayList<Task> tasks = new ArrayList<>();
    protected static int numberTasks = 0;
    private static String welcome = "Hello! I'm Michael\n" +
            "What can I do for you?";
    private static String exit = "Bye! Hope to see you again soon!";
    private static String ending_line = "bye";

    private static String home = System.getProperty("user.home");
    private static java.nio.file.Path dataPath = java.nio.file.Paths.get(home, "michael.txt");
    private static String dataFile = String.valueOf(dataPath);


    public static void addTask(Task t, boolean isDataNew) {
        tasks.add(t);
        numberTasks++;

        if (isDataNew) {
            System.out.println("Got it. I've added this task:");
            System.out.println(t);
            System.out.println("Now you have " + numberTasks + " tasks in the list.");
        }
    }

    public static void showList() {
        System.out.println("Hello there! Certainly, here are the tasks in your list:");
        for (int i = 0; i < numberTasks; i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toString());
        }
        System.out.println("You currently have " + numberTasks + " task(s)");
    }

    public static void markTask(int index) {
        Task currentTask = tasks.get(index);
        currentTask.markAsDone(); //mark as done
        WriteToFile.writeToPosition(dataFile, index, "0", "1");
        System.out.println("Good job! I've marked this task as done:");
        System.out.println(currentTask);
    }

    public static void unmarkTask(int index) {
        Task currentTask = tasks.get(index);

        currentTask.markAsUndone(); //mark as done
        WriteToFile.writeToPosition(dataFile, index, "1", "0");
        System.out.println("Alright, I've marked this task as not done yet:");
        System.out.println(currentTask);
    }


    public static void createTodo(String input, boolean isTaskDone, boolean isNew) {
        Task t = new Todo(input, dataFile, numberTasks + 1, isTaskDone, isNew);
        addTask(t, isNew);
    }

    public static void createDeadline(String input, boolean isTaskDone, boolean isNew) {
        String[] deadlineInstruction = input.split(" /by ", 2);
        Task t = new Deadline(deadlineInstruction[0], deadlineInstruction[1], dataFile, numberTasks + 1, isTaskDone, isNew);
        addTask(t, isNew);
    }

    public static void createEvent(String input, boolean isTaskDone, boolean isNew) {
        String[] eventInstruction = input.split(" /from ", 2);
        String[] eventDuration = eventInstruction[1].split(" /to ", 2);
        Task t = new Event(eventInstruction[0], eventDuration[0], eventDuration[1], dataFile, numberTasks + 1, isTaskDone, isNew);
        addTask(t, isNew);
    }

    public static void deleteTask(int t) {
        Task removedTask = tasks.get(t);
        tasks.remove(removedTask);
        numberTasks--;
        WriteToFile.deleteTask(dataFile, t);
        System.out.println("Of course, I've removed this task:");
        System.out.println(removedTask);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    private static void getFileContent(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        boolean isTaskDone;
        while (s.hasNext()) {
            String line = s.nextLine(); // Read the next line once
            isTaskDone = line.charAt(7) == '1';
            if (line.charAt(3) == 'T') {
                createTodo(line.substring(11), isTaskDone, false);
            } else if (line.charAt(3) == 'D') {
                String taskSub = line.substring(11);
                String newTaskSub = taskSub.replace("|", "/by");
//                System.out.println(newTaskSub);
                createDeadline(newTaskSub, isTaskDone, false);
            } else {
                String taskSub = line.substring(11);
                String newTaskSub = taskSub.replace("|", "/from");
                newTaskSub = newTaskSub.replace("-", " /to ");
                createEvent(newTaskSub, isTaskDone, false);
            }
        }

    }


    public static void main(String[] args) {


        System.out.println(welcome);
        Scanner in = new Scanner(System.in);
        String line = "";
        WriteToFile.createFile(dataFile);

        try {
            getFileContent(dataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (!(line.equals(ending_line))) {

            line = in.nextLine();   //user input

            String[] instruction = line.split(" ", 2); // split input to find the type of instruction

            int index = 0;

            if (instruction[0].equals("mark") || instruction[0].equals("unmark") || instruction[0].equals("delete")) { //if mark/unmark/delete instruction, decrement integer by one
                try {
                    index = Integer.parseInt(instruction[1]) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid number, please try again");
                    continue;
                }
            }

            try {
                switch (instruction[0]) {
                case "bye":
                    System.out.println(exit);
                    break;
                case "list":
                    showList();
                    continue;
                case "mark":
                    if (index >= 0 && index < numberTasks) {
                        markTask(index);
                    } else {
                        throw new NumberRangeException();
                    }
                    continue;
                case "unmark":
                    if (index >= 0 && index < numberTasks) {
                        unmarkTask(index);
                    } else {
                        throw new NumberRangeException();
                    }
                    continue;
                case "todo":
                    if (instruction.length < 2) {
                        throw new EmptyException();
                    }
                    createTodo(instruction[1], false, true);

                    continue;
                case "deadline":
                    if (instruction.length < 2) {
                        throw new EmptyException();
                    }
                    createDeadline(instruction[1], false, true);
                    continue;
                case "event":
                    if (instruction.length < 2) {
                        throw new EmptyException();
                    }
                    createEvent(instruction[1], false, true);
                    continue;
                case "delete":
                    if (index >= 0 && index < numberTasks) {
                        deleteTask(index);
                    } else {
                        throw new NumberRangeException();
                    }
                    continue;
                default:
                    throw new UnknownInstructionException();
                }

            } catch (EmptyException e) {
                System.out.println("Oh No! The description of " + instruction[0] + " cannot be empty!");
            } catch (UnknownInstructionException e) {
                System.out.println("I don't understand the instruction " + instruction[0] + " :{");
            } catch (NumberRangeException e) {
                System.out.println("The number is not within range of the list, please try again");
            }

        }
    }
}
