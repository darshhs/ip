import java.util.Scanner;

public class Michael {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String welcome = "Hello! I'm Michael\n" +
                         "What can I do for you?";

        System.out.println(welcome);

        Scanner in = new Scanner(System.in);
        String line = "";

        String ending_line =  "bye";
        String exit = "Bye. Hope to see you again soon!";

        while (!(line.equals(ending_line))) {
            line = in.nextLine();
            System.out.println(line);
        }
        System.out.println(exit);

    }
}
