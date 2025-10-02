package michael.Ui;

import michael.TaskList.Task;

public class UserMessages {

    public UserMessages() {
    }

    public void welcomeMessage() {
        String message = "Welcome to Michael's Task Manager!\n" +
                "Let's get things done...";
        System.out.println(message);
    }

    public void exitMessage() {
        String message = "Okay team, that’s a wrap. I am leaving. Goodbye.";
        System.out.println(message);
    }

    public void addTaskMessage(Task t, int numberTasks) {
        System.out.println("Boom! Instant classic task, added:");
        System.out.println(t);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

    public void markTaskMessage() {

        System.out.println("Yes! Task is done. I am very proud of you. Like, manager-of-the-year proud:"
        );
    }

    public void unmarkTaskMessage() {
        System.out.println("I’m not superstitious, but I am a little ’stitious… Let’s unmark that task:");
    }

    public void deleteTaskMessage(Task removedTask, int numberTasks) {
        System.out.println("Goodbye, task. The worst thing about tasks was the dementors. Just kidding. Deleted:");
        System.out.println(removedTask);
        System.out.println("Now you have " + numberTasks + " tasks in the list.");
    }

}
