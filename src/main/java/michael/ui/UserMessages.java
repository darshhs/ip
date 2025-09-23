package michael.ui;

public class UserMessages {
    public static void welcomeMessage() {
        String message = "Hello! I'm Michael\n" +
                         "What can I do for you?";
        System.out.println(message);
    }

    public static void exitMessage() {
        String message =  "Bye! Hope to see you again soon!";
        System.out.println(message);
    }

    public static void addTaskMessage(Task t, int numberTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(t);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    public static void markTaskMessage() {
        System.out.println("Good job! I've marked this task as done:");
    }

    public static void unmarkTaskMessage() {
        System.out.println("Alright, I've marked this task as not done yet:");
    }

    public static void deleteTaskMessage(Task removedTask, int numberTasks) {
        System.out.println("Of course, I've removed this task:");
        System.out.println(removedTask);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

}
