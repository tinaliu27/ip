import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Task> tasksList = new ArrayList<Task>(100);
        printLogo();
        printHelloMessage();
        String task = sc.nextLine();
        while(!task.equals("bye")) {
            if(task.equals("list")) {
                int lister = 1;
                for(Task items: tasksList) {
                    System.out.println(lister + ". [" + items.getStatusIcon() + "]" + items.getDescription());
                    lister++;
                }
            } else {
                if(task.contains("mark")) {
                    System.out.println(task);
                    // splits user command if they type in mark 2 to get the integer value
                    String[] marker = task.split(" ");
                    // gets the integer value
                    int taskindex = Integer.parseInt(marker[1]);

                    if (taskindex >= tasksList.size()) {
                        System.out.println("Out of bounds");
                    } else {
                        Task t  = tasksList.get(taskindex);
                        t.setDone(true);
                        printLine();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("[" + t.getStatusIcon() + " ] " + t.getDescription());
                    }


                } else {
                    printLine();

                    System.out.println("\nadded: " + task);

                    Task newTask = new Task(task);
                    tasksList.add(newTask);
                }
            }
            printLine();
            task = sc.next();
        }
        printByeMessage();
    }
    public static void printHelloMessage() {
        String greet = "\nHello! I'm Arcadia\nWhat can I do for you?\n";
        printLine();
        System.out.println(greet);
    }
    public static void printLine() {
        for(int i = 0; i<30; i++) {
            System.out.print("-");
        }
    }
    public static void printLogo() {
        String logo = " ____        _        \n"
                + "| \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
    }
    public static void printByeMessage() {
        String goodbye = "Bye. Hope to see you again soon!\n";
        printLine();
        System.out.println(goodbye);
    }
}
