import java.util.Scanner;

public class Michael {

    private static Task[] tasks = new Task[100];
    private static int numberTasks = 0;

    public static void addTask(Task t) {
        tasks[numberTasks] = t;
        numberTasks++;
    }

    public static void main(String[] args) {

        String welcome = "Hello! I'm Michael\n" +
                "What can I do for you?";

        System.out.println(welcome);

        Scanner in = new Scanner(System.in);
        String line = "";

        String ending_line = "bye";
        String exit = "Bye! Hope to see you again soon!";

        while (!(line.equals(ending_line))) {

            line = in.nextLine();   //user input
            String[] Instruction = line.split(" ", 2); // split input to find the type of instruction
            int index = 0;

            if (Instruction[0].equals("mark") || Instruction[0].equals("unmark")) { //if mark/unmark instruction, decrement integer by one
                try {
                    index = Integer.parseInt(Instruction[1]) - 1;
                } catch (NumberFormatException e) {
                    index = 0;
                }
            }
            Task currentTask = tasks[index]; //when instruction is mark/unmark, use this variable

            if (line.equals("list")) {

                System.out.println("Hello there! Certainly, here are the tasks in your list:");
                for (int i = 0; i < numberTasks; i++) {
                    System.out.println((i + 1) + "." + tasks[i].toString());
                }

            } else if (Instruction[0].equals("mark")) {

                if (index >= 0 && index < numberTasks) { //check that input is within range
                    currentTask.markAsDone(); //mark as done
                    System.out.println("Good job! I've marked this task as done:");
                    System.out.println(currentTask);
                }

            } else if (Instruction[0].equals("unmark")) {

                if (index >= 0 && index < numberTasks) {
                    currentTask.markAsUndone(); //mark as undone
                    System.out.println("Alright, I've marked this task as not done yet:");
                    System.out.println(currentTask);
                }

            } else {

                switch (Instruction[0]) { //switch between different types of instruction
                case "todo" -> {
                    Task t = new Todo(Instruction[1]);
                    addTask(t);

                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println("Now you have " + numberTasks + " tasks in the list.");
                    continue;
                }
                case "deadline" -> {

                    String[] deadlineInstruction = Instruction[1].split(" /by ", 2);
                    Task t = new Deadline(deadlineInstruction[0], deadlineInstruction[1]);
                    addTask(t);

                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println("Now you have " + numberTasks + " tasks in the list.");
                    continue;
                }
                case "event" -> {

                    String[] eventInstruction = Instruction[1].split(" /from ", 2);
                    String[] eventDuration = eventInstruction[1].split(" /to ", 2);
                    Task t = new Event(eventInstruction[0], eventDuration[0], eventDuration[1]);
                    addTask(t);

                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println("Now you have " + numberTasks + " tasks in the list.");
                    continue;
                }
                }

                if (!line.equals(ending_line)) { //if no T/D/E of instruction is given by user
                    Task t = new Task(line);
                    addTask(t);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(t);
                    System.out.println("Now you have " + numberTasks + " tasks in the list.");
                }
            }
        }
        System.out.println(exit);
    }
}
