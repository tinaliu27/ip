import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasksList = new ArrayList<Task>(100);
        String LINESEPERATOR = "----------------------------";
        String logo = " ____        _        \n"
                + "| \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "\n" + LINESEPERATOR);

        String greet = "Hello! I'm Arcadia\nWhat can I do for you?\n" + LINESEPERATOR;
        System.out.println(greet);
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
                        System.out.println(LINESEPERATOR + "Nice! I've marked this task as done:");
                        System.out.println("[" + t.getStatusIcon() + " ] " + t.getDescription());
                    }


                } else {
                    System.out.println(LINESEPERATOR + "added: " + task);
                    Task newTask = new Task(task);
                    tasksList.add(newTask);
                }
            }
            System.out.print(LINESEPERATOR);
            task = sc.next();
        }
        String goodbye = "Bye. Hope to see you again soon!\n"+LINESEPERATOR;
        System.out.println(goodbye);
    }
}
