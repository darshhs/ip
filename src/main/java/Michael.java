import java.util.Scanner;

public class Michael {

    private static Task[] tasks = new Task[100];
    private static int numberTasks = 0;
    private static String welcome = "Hello! I'm Michael\n" +
                                    "What can I do for you?";
    private static String exit = "Bye! Hope to see you again soon!";
    private static String ending_line = "bye";


    public static void addTask(Task t) {
        tasks[numberTasks] = t;
        numberTasks++;
        System.out.println("Got it. I've added this task:");
        System.out.println(t);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    public static void showList() {
        System.out.println("Hello there! Certainly, here are the tasks in your list:");
        for (int i = 0; i < numberTasks; i++) {
            System.out.println((i + 1) + "." + tasks[i].toString());
        }
    }

    public static void markTask(Task currentTask) {
        currentTask.markAsDone(); //mark as done
        System.out.println("Good job! I've marked this task as done:");
        System.out.println(currentTask);
    }

    public static void unmarkTask(Task currentTask) {
        currentTask.markAsUndone(); //mark as undone
        System.out.println("Alright, I've marked this task as not done yet:");
        System.out.println(currentTask);
    }

    public static void createTodo(String input) {
        Task t = new Todo(input);
        addTask(t);
    }

    public static void createDeadline(String input) {
        String[] deadlineInstruction = input.split(" /by ", 2);
        Task t = new Deadline(deadlineInstruction[0], deadlineInstruction[1]);
        addTask(t);
    }

    public static void createEvent(String input) {
        String[] eventInstruction = input.split(" /from ", 2);
        String[] eventDuration = eventInstruction[1].split(" /to ", 2);
        Task t = new Event(eventInstruction[0], eventDuration[0], eventDuration[1]);
        addTask(t);
    }

    public static void ordinaryTask(String input) {
        Task t = new Task(input);
        addTask(t);
    }

    public static void main(String[] args) {

        System.out.println(welcome);
        Scanner in = new Scanner(System.in);
        String line = "";

        while (!(line.equals(ending_line))) {

            line = in.nextLine();   //user input

            String[] instruction = line.split(" ", 2); // split input to find the type of instruction

            int index = 0;
            if (instruction[0].equals("mark") || instruction[0].equals("unmark")) { //if mark/unmark instruction, decrement integer by one
                try {
                    index = Integer.parseInt(instruction[1]) - 1;
                } catch (NumberFormatException e) {
                    index = 0;
                }
            }

            Task currentTask = tasks[index]; //when instruction is mark/unmark, use this variable

            switch (instruction[0]) {
            case "bye":
                System.out.println(exit);
                break;
            case "list":
                showList();
                continue;
            case "mark":
                if (index >= 0 && index < numberTasks) {
                    markTask(currentTask);
                }
                continue;
            case "unmark":
                if (index >= 0 && index < numberTasks) {
                    unmarkTask(currentTask);
                }
                continue;
            case "todo":
                createTodo(instruction[1]);
                continue;
            case "deadline":
                createDeadline(instruction[1]);
                continue;
            case "event":
                createEvent(instruction[1]);
                continue;
            default:
                ordinaryTask(line);
            }

        }
    }
}
