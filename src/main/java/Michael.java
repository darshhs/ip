import java.util.Scanner;

public class Michael {
    public static void main(String[] args) {

        String welcome = "Hello! I'm Michael\n" +
                         "What can I do for you?";

        System.out.println(welcome);

        Scanner in = new Scanner(System.in);
        String line = "";

        String[] results = new String [100];
        int currentData = 0;

        String ending_line =  "bye";
        String exit = "Bye. Hope to see you again soon!";

        while (!(line.equals(ending_line))) {
            line = in.nextLine();
            if (line.equals("list")) {
                int index = 1;
                for(int i = 0; i < currentData; i++) {
                    System.out.println(index + ". " + results[i]);
                    index += 1;
                }
            } else {
                results[currentData] = line;
                currentData += 1;
                System.out.println("Added: " + line);
            }

        }
        System.out.println(exit);

    }
}
