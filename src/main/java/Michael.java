import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Michael {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        String welcome = "Hello! I'm Michael\n" +
                "What can I do for you?";

        System.out.println(welcome);

        Scanner in = new Scanner(System.in);
        String line = "";

        String ending_line = "bye";
        String exit = "Bye! Hope to see you again soon!";


        while (!(line.equals(ending_line))) {
            line = in.nextLine();
            String[] Instruction = line.split(" ", 2);
            int index = 0;

            if (Instruction[0].equals("mark") || Instruction[0].equals("unmark")) {
                try {
                    index = Integer.parseInt(Instruction[1]) - 1;
                } catch (NumberFormatException e) {
                    index = 0;
                }
            }

            if (line.equals("list")) {
                System.out.println("Hello there! Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + "." + "[" + ((tasks.get(i).isDone) ? "X" : " ") + "] " + tasks.get(i).description);
                }
            } else if (Instruction[0].equals("mark")) {
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).markAsDone();
                    System.out.println("Good job! I've marked this task as done:");
                    System.out.println("  [" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).description);
                }
            } else if (Instruction[0].equals("unmark")) {
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).markAsUndone();
                    System.out.println("Alright, I've marked this task as not done yet:");
                    System.out.println("  [" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).description);
                }
            } else {
                if (!line.equals(ending_line)) {
                    tasks.add(new Task(line));
                    System.out.println("Added: " + line);
                }
            }
        }
        System.out.println(exit);

    }
}
