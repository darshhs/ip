package michael.Ui;

import michael.TaskList.Task;

/**
 *
 * This class handles user-facing messages for the chatbot.
 * Each method outputs formatted messages to the console to inform the user
 * about the application's state and operations performed on tasks.
 *
 */

public class UserMessages {

    public UserMessages() {
    }

    /**
     * Prints welcome message
     */
    public void welcomeMessage() {
        String message = "Welcome to Michael's Task Manager!\n" +
                "Let's get things done...";
        System.out.println(message);
    }

    /**
     * Prints exit message
     */
    public void exitMessage() {
        String message = "Okay team, that’s a wrap. I am leaving. Goodbye.";
        System.out.println(message);
    }

    /**
     * Prints all the tasks in the file
     */
    public void addTaskMessage(Task t, int numberTasks) {
        System.out.println("Boom! Instant classic task, added:");
        System.out.println(t);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    /**
     * Prints message when each task is marked
     */
    public void markTaskMessage() {

        System.out.println("Yes! Task is done. I am very proud of you. Like, manager-of-the-year proud:"
        );
    }

    /**
     * Prints message when each task is unmarked
     */
    public void unmarkTaskMessage() {
        System.out.println("I’m not superstitious, but I am a little ’stitious… Let’s unmark that task:");
    }

    /**
     * Prints message when each task is deleted
     */
    public void deleteTaskMessage(Task removedTask, int numberTasks) {
        System.out.println("Goodbye, task. The worst thing about tasks was the dementors. Just kidding. Deleted:");
        System.out.println(removedTask);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    /**
     * Prints message when users asks to find all tasks that contains a specific keyword
     */
    public void findTasksMessage() {
        System.out.println("Here are the matching tasks in your list:");
    }

}
